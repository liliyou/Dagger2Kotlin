package com.demo.android.view.component

import android.app.Application
import com.demo.android.AppApplication
import com.demo.android.view.SettingView
import com.demo.android.view.activity.SettingActivity
import com.demo.android.view.module.SettingModule
import com.demo.android.view.scope.Setting
import dagger.Component

@Setting
@Component(dependencies = arrayOf(GlobalComponent::class),
        modules = arrayOf(SettingModule::class))
interface SettingComponent {

    fun inject(activity: SettingActivity)

    object Initializer {

        fun init(app: Application, view: SettingView): SettingComponent {

            val component = DaggerSettingComponent.builder()
                    .globalComponent((app as AppApplication).component())
                    .settingModule(SettingModule(view)).build()
            return component
        }
    }
}