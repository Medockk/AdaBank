package com.example.adabank.feature_app.domain.usecase.Contact

import com.example.adabank.feature_app.domain.model.Contact
import com.example.adabank.feature_app.domain.repository.ContactRepository
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

class GetContactDataUseCase(
    private val contactRepository: ContactRepository
) {

    suspend operator fun invoke(userID: String) : Flow<NetworkResult<List<Contact>>>{
        return contactRepository.getData(userID)
    }
}