package com.demo.android.presenter.internal

import com.demo.android.model.User
import com.demo.android.presenter.SettingPresenter
import com.demo.android.view.SettingView
import javax.inject.Inject

/**
 * Created by lili on 2017/1/15.
 */
class SettingPresenterImpl @Inject constructor(private val mView: SettingView, private val mUser: User) : SettingPresenter {

    override fun getUserName(): String {
        return mUser.getUserName()
    }

    override fun setUserName(name: String) {
        mUser.setUserName(name)
        mView.updateUserName(name)
    }
}

