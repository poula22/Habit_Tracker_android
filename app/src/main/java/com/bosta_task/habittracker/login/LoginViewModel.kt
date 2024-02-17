package com.bosta_task.habittracker.login

import androidx.lifecycle.ViewModel
import com.bosta_task.habittracker.login.model.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _loginScreenState = MutableStateFlow(LoginState())
    val loginState = _loginScreenState.asStateFlow()

    fun onEvent(event:LoginEvent){
        when(event){
            is LoginEvent.ChangeEmail -> {
                _loginScreenState.update { it.copy(
                    email = event.email
                ) }
            }
            is LoginEvent.ChangePassword -> {
                _loginScreenState.update { it.copy(
                    password = event.password
                ) }
            }
            LoginEvent.ShowPasswordClicked -> {
                _loginScreenState.update { it.copy(
                    isShowPassword = !it.isShowPassword
                ) }
            }
            else -> Unit
        }
    }
}