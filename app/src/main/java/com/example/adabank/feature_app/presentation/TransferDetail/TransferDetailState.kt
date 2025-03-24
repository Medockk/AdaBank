package com.example.adabank.feature_app.presentation.TransferDetail

data class TransferDetailState(
    val exception: String = "",
    val amount: String = "",
    val currency: String = "USD",

    val showIndicator: Boolean = false,
)
