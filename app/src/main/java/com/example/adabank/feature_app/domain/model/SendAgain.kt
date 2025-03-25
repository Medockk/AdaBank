package com.example.adabank.feature_app.domain.model

import com.example.adabank.feature_app.data.data_source.local.SendAgainDto

data class SendAgain(
    val id: Int,
    val userID: String,
    val image: String,
    val name: String,
    val bankCardNumber: String
){
    fun toSendAgainDto() : SendAgainDto{
        return SendAgainDto(id, userID, image, name, bankCardNumber)
    }
}