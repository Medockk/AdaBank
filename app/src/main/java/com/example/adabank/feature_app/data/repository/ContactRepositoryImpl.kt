package com.example.adabank.feature_app.data.repository

import com.example.adabank.feature_app.data.data_source.local.ContactDao
import com.example.adabank.feature_app.data.data_source.local.ContactDto
import com.example.adabank.feature_app.domain.model.Contact
import com.example.adabank.feature_app.domain.repository.ContactRepository
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ContactRepositoryImpl(
    private val contactDao: ContactDao
) : ContactRepository {

    override suspend fun upsertData(contactDto: ContactDto) {
        contactDao.upsertData(contactDto)
    }

    override suspend fun getData(userID: String) = flow<NetworkResult<List<Contact>>> {

        emit(NetworkResult.Loading())
        emit(NetworkResult.Success(contactDao.getData(userID).map { it.toContact() }))

        //getNetwork data? //idk
    }.catch {
        emit(NetworkResult.Error(it.localizedMessage))
    }

    override suspend fun clearData() {
        contactDao.clearData()
    }
}