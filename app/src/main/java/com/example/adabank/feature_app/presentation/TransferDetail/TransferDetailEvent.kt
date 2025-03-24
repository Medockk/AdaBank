package com.example.adabank.feature_app.presentation.TransferDetail

sealed class TransferDetailEvent {

    data object ResetException : TransferDetailEvent()
    data class EnterAmount(val value: String) : TransferDetailEvent()
    data class ChangeShowIndicatorState(val value: Boolean) : TransferDetailEvent()

    data object DeleteLastCharacter : TransferDetailEvent()
}