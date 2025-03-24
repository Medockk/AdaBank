package com.example.adabank.feature_app.domain.model

import com.example.adabank.feature_app.data.data_source.local.ContactDto

data class Contact(
    val id: Int,
    val userID: String,
    val icon: String,
    val name: String,
    val bankCardNumber: String,
){
    fun toContactDto() : ContactDto{
        return ContactDto(id, userID, icon, name, bankCardNumber)
    }
}