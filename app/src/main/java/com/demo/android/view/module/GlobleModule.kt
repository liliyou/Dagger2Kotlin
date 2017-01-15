package com.demo.android.view.module

import com.demo.android.model.User
import com.demo.android.model.UserManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 */
@Module
class GlobleModule() {

    @Provides
    @Singleton
    fun provideUser(): User {
        return UserManager()
    }
}