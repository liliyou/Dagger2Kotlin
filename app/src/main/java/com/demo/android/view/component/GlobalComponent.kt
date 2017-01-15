package com.demo.android.view.component

import com.demo.android.AppApplication
import com.demo.android.model.User
import com.demo.android.view.module.GlobleModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 */
@Singleton
@Component(modules = arrayOf(
        GlobleModule::class)
)
interface GlobalComponent {

     fun inject(app: AppApplication)

     fun getUser(): User

}