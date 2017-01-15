package com.demo.android.view.activity

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import com.demo.android.R
import com.demo.android.presenter.SettingPresenter
import com.demo.android.view.SettingView
import com.demo.android.view.component.SettingComponent
import javax.inject.Inject

class SettingActivity : AppCompatActivity(), SettingView {


    lateinit var mUserNameTextView: TextView
    lateinit var mChangeNameButton: TextView

    @Inject
    lateinit var mPresenter: SettingPresenter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SettingComponent.Initializer.init(application, this).inject(this)

        setContentView(R.layout.activity_setting)
        mUserNameTextView = findViewById(R.id.settingPage_userNameTextView) as TextView
        mChangeNameButton = findViewById(R.id.settingPage_changeUserNameButton) as TextView


        mChangeNameButton.setOnClickListener { view -> displayDialog() }
        updateUserName(mPresenter.getUserName())

    }

    fun displayDialog() {
        val dialogView = layoutInflater.inflate(R.layout.activity_setting_dialog, null)

        val renameDialog = AlertDialog.Builder(this)
                .setTitle("Change User Name")
                .setView(dialogView)
                .setPositiveButton("OK") { dialog, which ->
                    val renameEditText = dialogView.findViewById(R.id.settingPage_dialogRenameEditText) as EditText
                    mPresenter.setUserName(renameEditText.text.toString())
                    dialog.dismiss()
                    setResult(Activity.RESULT_OK)
                }.setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }.create()

        renameDialog.show()
    }


    override fun updateUserName(userName: String) {
        mUserNameTextView.setText(userName)
    }


}
