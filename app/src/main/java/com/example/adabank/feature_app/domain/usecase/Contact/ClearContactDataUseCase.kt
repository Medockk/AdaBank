package com.example.adabank.feature_app.domain.usecase.Contact

import com.example.adabank.feature_app.domain.repository.ContactRepository

class ClearContactDataUseCase(
    private val contactRepository: ContactRepository
) {

    suspend operator fun invoke(){
        contactRepository.clearData()
    }
}