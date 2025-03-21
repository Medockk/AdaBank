package com.example.adabank.feature_app.presentation.SetPin

sealed class SetPinEvent {

    data object ResetException : SetPinEvent()
    data class SetPin(val value: String) : SetPinEvent()
    data object NextClick: SetPinEvent()

    data object DeletePinCharacter : SetPinEvent()
}