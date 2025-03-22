package com.example.adabank.feature_app.presentation.Login

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.usecase.Auth.SendOtpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val sendOtpUseCase: SendOtpUseCase
) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent){
        when (event){
            is LoginEvent.EnterPhone -> {
                if (_state.value.phone.length <= 10){
                    _state.value = state.value.copy(
                        phone = event.value
                    )
                }
            }
            LoginEvent.ResetException -> {
                _state.value = state.value.copy(
                    exception = ""
                )
            }

            LoginEvent.Login -> {
                if (_state.value.phone.length >= 10){
                    viewModelScope.launch(Dispatchers.IO) {
                        _state.value = state.value.copy(showIndicator = true)
                        try {
                            sendOtpUseCase("8${_state.value.phone}")
                            _state.value = state.value.copy(isSendOtp = true)
                        } catch (e: Exception) {
                            _state.value = state.value.copy(exception = e.message.toString())
                        }
                        _state.value = state.value.copy(showIndicator = false)
                    }
                }
            }
            is LoginEvent.DeletePhoneCharacter -> {
                _state.value = state.value.copy(
                    phone = _state.value.phone.dropLast(1)
                )
            }

            is LoginEvent.EnterOtpCode -> {
                _state.value = state.value.copy(
                    otpCode = event.value
                )
                if (_state.value.otpCode.length == 4){
                    _state.value = state.value.copy(isComplete = true)
                }
                if (event.value.isEmpty()){
                    _state.value = state.value.copy(isComplete = false, isSendOtp = false)
                }
            }

            LoginEvent.StartResendTimer -> {
                val timer = object : CountDownTimer(60000, 1000){
                    override fun onTick(time: Long) {
                        _state.value = state.value.copy(
                            resendCodeTime = (time / 1000).toString()
                        )
                    }

                    override fun onFinish() {
                        _state.value = state.value.copy(resendCodeTime = "")
                    }
                }
                timer.start()
            }
        }
    }
}