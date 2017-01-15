package com.demo.android

import android.app.Application
import com.demo.android.view.component.DaggerGlobalComponent
import com.demo.android.view.component.GlobalComponent

/**
 * Created by lili on 2017/1/15.
 */
class AppApplication: Application() {

    companion object {
        lateinit var globalComponent: GlobalComponent
    }

    override fun onCreate() {
        super.onCreate()
        globalComponent = DaggerGlobalComponent.create();

    }

    fun component(): GlobalComponent {
        return globalComponent
    }
}