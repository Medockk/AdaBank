package com.example.adabank.feature_app.presentation.Transfer

import android.net.Uri

sealed class TransferEvent {

    data object ResetException : TransferEvent()

    data class GetContact(val value: Uri) : TransferEvent()
    data class EnterSearchText(val value: String) : TransferEvent()
    data class ChangeSelectedContactNumber(val value: Int) : TransferEvent()
}