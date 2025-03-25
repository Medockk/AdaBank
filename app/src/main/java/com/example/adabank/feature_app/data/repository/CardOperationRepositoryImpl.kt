package com.example.adabank.feature_app.data.repository

import com.example.adabank.feature_app.data.data_source.local.CardOperationDao
import com.example.adabank.feature_app.domain.model.SendAgain
import com.example.adabank.feature_app.domain.model.TransactionHistory
import com.example.adabank.feature_app.domain.repository.CardOperationRepository
import com.example.adabank.feature_app.domain.utils.NetworkResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CardOperationRepositoryImpl(
    private val cardOperationDao: CardOperationDao
) : CardOperationRepository {

    override suspend fun upsertSendAgainData(sendAgain: SendAgain) {
        cardOperationDao.upsertSendAgainData(sendAgain.toSendAgainDto())
    }

    override suspend fun getSendAgainData(userID: String) = flow<NetworkResult<List<SendAgain>>> {

        emit(NetworkResult.Loading())
        emit(NetworkResult.Success(cardOperationDao.getSendAgainData(userID).map { it.toSendAgain() }))
    }.catch {
        emit(NetworkResult.Error(it.localizedMessage))
    }

    override suspend fun clearSendAgainData() {
        cardOperationDao.clearSendAgainData()
    }

    override suspend fun upsertTransactionData(transactionHistory: TransactionHistory) {
        cardOperationDao.upsertTransactionData(transactionHistory.toTransactionHistoryDto())
    }

    override suspend fun getTransactionHistoryData(userID: String) = flow<NetworkResult<List<TransactionHistory>>> {

        emit(NetworkResult.Loading())

        emit(NetworkResult.Success(cardOperationDao.getTransactionHistoryData(userID).map { it.toTransactionHistory() }))
    }.catch {
        emit(NetworkResult.Error(it.localizedMessage))
    }

    override suspend fun clearTransactionHistoryData() {
        cardOperationDao.clearTransactionHistoryData()
    }
}