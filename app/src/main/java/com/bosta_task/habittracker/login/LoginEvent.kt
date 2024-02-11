package com.bosta_task.habittracker.login

sealed interface LoginEvent {
    data class ChangeEmail(val email: String): LoginEvent
    data class ChangePassword(val password: String): LoginEvent
    data object LoginClicked: LoginEvent
    data object ShowPasswordClicked: LoginEvent
    data object ForgetPasswordClicked: LoginEvent
    data object SignUpClicked: LoginEvent
}