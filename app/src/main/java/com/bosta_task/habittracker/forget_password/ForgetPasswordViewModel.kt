package com.bosta_task.habittracker.forget_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class ForgetPasswordViewModel : ViewModel() {
    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow: SharedFlow<String> = _sharedFlow
    fun sendResetEmail() {
        viewModelScope.launch {
            try {
                //sendResetEmail
                _sharedFlow.emit("A link send to your email successfully")
            }catch (_:Exception){
                _sharedFlow.emit("Server not available at the moment please try again later")
            }
        }
    }
}