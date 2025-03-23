package com.example.adabank.feature_app.presentation.SetPin

data class SetPinState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val pin: String = "",
    val isComplete: Boolean = false,
    val isAuthenticated: Boolean = false,
)
