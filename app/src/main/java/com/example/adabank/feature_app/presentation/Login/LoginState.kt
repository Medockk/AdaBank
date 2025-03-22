package com.example.adabank.feature_app.presentation.Login

data class LoginState(
    val exception: String = "",
    val phone: String = "",
    val isSendOtp: Boolean = false,
    val isComplete: Boolean = false,
    val showIndicator: Boolean = false,

    val countyPhoneCode: String = "+7",
    val otpCode: String = "",
    val resendCodeTime: String = "",
)
