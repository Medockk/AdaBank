package com.example.adabank.feature_app.domain.usecase.CardOperation

import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.repository.CardOperationRepository

class UpsertSendAgainDataUseCase(
    private val cardOperationRepository: CardOperationRepository
){

    suspend operator fun invoke(sendAgain: SendAgain){
        cardOperationRepository.upsertSendAgainData(sendAgain)
    }
}