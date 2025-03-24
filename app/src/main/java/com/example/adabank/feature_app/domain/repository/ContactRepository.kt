package com.example.adabank.feature_app.domain.repository

import com.example.adabank.feature_app.data.data_source.local.ContactDto
import com.example.adabank.feature_app.domain.model.Contact
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    suspend fun upsertData(contactDto: ContactDto)
    suspend fun getData(userID: String) : Flow<NetworkResult<List<Contact>>>
    suspend fun clearData()
}