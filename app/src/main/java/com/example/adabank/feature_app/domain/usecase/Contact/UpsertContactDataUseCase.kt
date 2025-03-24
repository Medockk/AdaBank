package com.example.adabank.feature_app.domain.usecase.Contact

import com.example.adabank.feature_app.data.data_source.local.ContactDto
import com.example.adabank.feature_app.domain.repository.ContactRepository

class UpsertContactDataUseCase(
    private val contactRepository: ContactRepository
) {

    suspend operator fun invoke(contactDto: ContactDto){
        contactRepository.upsertData(contactDto)
    }
}