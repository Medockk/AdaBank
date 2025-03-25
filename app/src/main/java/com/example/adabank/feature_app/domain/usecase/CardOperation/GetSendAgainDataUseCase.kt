package com.example.adabank.feature_app.domain.usecase.CardOperation

import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.repository.CardOperationRepository
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

class GetSendAgainDataUseCase(
    private val cardOperationRepository: CardOperationRepository
) {

    suspend operator fun invoke(userID: String) : Flow<NetworkResult<List<SendAgain>>>{
        return cardOperationRepository.getSendAgainData(userID)
    }
}