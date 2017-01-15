package com.demo.android.model

/**
 * Created by lili on 2017/1/15.
 */
class UserManager : User {

    private val DEFAULT_USER = "User:)"

    private var mUserName = DEFAULT_USER

     override fun getUserName(): String {
        return mUserName
    }

     override fun setUserName(userName: String) {
        mUserName = userName
    }

}