package com.bosta_task.habittracker.login.model

data class LoginState(
    val email:String? = null,
    val password:String? = null,
    val isLogInVerified:Boolean? = null,
    val isShowPassword:Boolean = false,
    val isForgetPasswordClicked:Boolean = false,
    val isSignUpClicked:Boolean = false
    )
