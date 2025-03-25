package com.example.adabank.feature_app.domain.usecase.CardOperation

import com.example.adabank.feature_app.domain.repository.CardOperationRepository

class ClearSendAgainDataUseCase(
    private val cardOperationRepository: CardOperationRepository
) {

    suspend operator fun invoke(){
        cardOperationRepository.clearSendAgainData()
    }
}