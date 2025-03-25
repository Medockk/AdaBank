package com.example.adabank.feature_app.domain.usecase.CardOperation

import com.example.adabank.feature_app.domain.model.TransactionHistory
import com.example.adabank.feature_app.domain.repository.CardOperationRepository

class UpsertTransactionDataUseCase(
    private val cardOperationRepository: CardOperationRepository
) {

    suspend operator fun invoke(transactionHistory: TransactionHistory){
        cardOperationRepository.upsertTransactionData(transactionHistory)
    }
}