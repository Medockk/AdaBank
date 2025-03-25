package com.example.adabank.feature_app.presentation.Receipt

import com.example.adabank.feature_app.presentation.Route
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class ReceiptState(
    val exception: String = "",

    val transactionDate: String = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern(
            "dd MMM yyyy HH:mm:ss"
        )),
    val amount: String = Route.TransferDetailScreen.amount
)
