package com.example.adabank.feature_app.domain.repository

import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.model.TransactionHistory
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CardOperationRepository {

    suspend fun upsertSendAgainData(sendAgain: SendAgain)
    suspend fun getSendAgainData(userID: String) : Flow<NetworkResult<List<SendAgain>>>
    suspend fun clearSendAgainData()
    suspend fun upsertTransactionData(transactionHistory: TransactionHistory)
    suspend fun getTransactionHistoryData(userID: String) : Flow<NetworkResult<List<TransactionHistory>>>
    suspend fun clearTransactionHistoryData()
}