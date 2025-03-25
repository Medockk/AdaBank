package com.example.adabank.feature_app.domain.model

import com.example.adabank.feature_app.data.data_source.local.TransactionHistoryDto

data class TransactionHistory(

    val id: Int,
    val userID: String,
    val image: String,
    val title: String,
    val date: String,
    val price: String,
    val sendTo: String,
){
    fun toTransactionHistoryDto() : TransactionHistoryDto{
        return TransactionHistoryDto(id, userID, image, title, date, price, sendTo)
    }
}