package com.demo.android.view.module

import com.demo.android.model.User
import com.demo.android.presenter.SettingPresenter
import com.demo.android.presenter.internal.SettingPresenterImpl
import com.demo.android.view.SettingView
import dagger.Module
import dagger.Provides

@Module
class SettingModule(private val view: SettingView) {


    @Provides
    fun getPresenter(user: User): SettingPresenter {

        return SettingPresenterImpl(view, user)
    }
}
