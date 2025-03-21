package com.example.adabank.feature_app.presentation.Login

sealed class LoginEvent {

    data object ResetException: LoginEvent()
    data class EnterPhone(val value: String) : LoginEvent()
    data class EnterOtpCode(val value: String) : LoginEvent()
    data object DeletePhoneCharacter: LoginEvent()

    data object StartResendTimer : LoginEvent()

    data object Login : LoginEvent()
}