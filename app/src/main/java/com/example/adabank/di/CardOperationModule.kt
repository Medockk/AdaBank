package com.example.adabank.di

import android.content.Context
import com.example.adabank.feature_app.data.data_source.local.CardOperationDao
import com.example.adabank.feature_app.data.data_source.local.database.CardOperationsDatabase
import com.example.adabank.feature_app.data.repository.CardOperationRepositoryImpl
import com.example.adabank.feature_app.domain.repository.CardOperationRepository
import com.example.adabank.feature_app.domain.usecase.CardOperation.ClearSendAgainDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.ClearTransactionHistoryDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.GetSendAgainDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.GetTransactionHistoryDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.UpsertSendAgainDataUseCase
import com.example.adabank.feature_app.domain.usecase.CardOperation.UpsertTransactionDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CardOperationModule {

    @Singleton
    @Provides
    fun getDao(@ApplicationContext context: Context) : CardOperationDao{
        val database = CardOperationsDatabase.createDatabase(context)
        return database.cardOperationDao
    }

    @Provides
    @Singleton
    fun getRepository(cardOperationDao: CardOperationDao) : CardOperationRepository{
        return CardOperationRepositoryImpl(cardOperationDao)
    }

    @Provides
    @Singleton
    fun clearSendAgain(cardOperationRepository: CardOperationRepository) : ClearSendAgainDataUseCase{
        return ClearSendAgainDataUseCase(cardOperationRepository)
    }
    @Provides
    @Singleton
    fun clearTransactionHistory(cardOperationRepository: CardOperationRepository) : ClearTransactionHistoryDataUseCase{
        return ClearTransactionHistoryDataUseCase(cardOperationRepository)
    }
    @Provides
    @Singleton
    fun getSendAgain(cardOperationRepository: CardOperationRepository) : GetSendAgainDataUseCase{
        return GetSendAgainDataUseCase(cardOperationRepository)
    }
    @Provides
    @Singleton
    fun getTransactionHistory(cardOperationRepository: CardOperationRepository) : GetTransactionHistoryDataUseCase{
        return GetTransactionHistoryDataUseCase(cardOperationRepository)
    }
    @Provides
    @Singleton
    fun upsertSendAgain(cardOperationRepository: CardOperationRepository) : UpsertSendAgainDataUseCase{
        return UpsertSendAgainDataUseCase(cardOperationRepository)
    }
    @Provides
    @Singleton
    fun upsertTransactionHistory(cardOperationRepository: CardOperationRepository) : UpsertTransactionDataUseCase{
        return UpsertTransactionDataUseCase(cardOperationRepository)
    }
}