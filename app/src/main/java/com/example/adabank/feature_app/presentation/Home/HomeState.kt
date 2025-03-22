package com.example.adabank.feature_app.presentation.Home

import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.model.TransactionHistory

data class HomeState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val name: String = "Senya",
    val totalBalance: String = "999,54",

    val sendAgainList: List<SendAgain> = emptyList(),
    val transactionList: List<TransactionHistory> = emptyList(),

    val userImage: String = "https://uftclonibwagnofwkbtp.supabase.co/storage/v1/object/public/avatars//Image_profile.png",
)
