package com.example.adabank.feature_app.domain.model

interface TransactionHistory {

    val id: Int
    val userID: String
    val image: String
    val title: String
    val date: String
    val price: String
    val sendTo: String
}