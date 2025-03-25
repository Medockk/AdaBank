package com.example.adabank.feature_app.domain.usecase.CardOperation

import com.example.adabank.feature_app.domain.repository.CardOperationRepository

class ClearTransactionHistoryDataUseCase(
    private val cardOperationRepository: CardOperationRepository
) {

    suspend operator fun invoke(){
        cardOperationRepository.clearTransactionHistoryData()
    }
}