package com.example.adabank.feature_app.presentation.Transfer

import com.example.adabank.feature_app.domain.model.Contact

data class TransferState(
     val exception: String = "",

     val searchText: String = "",
     val contactList: List<Contact> = emptyList(),
     val selectedContactNumber: Int = 0,
)
