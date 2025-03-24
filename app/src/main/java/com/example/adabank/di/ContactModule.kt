package com.example.adabank.di

import android.content.Context
import com.example.adabank.feature_app.data.data_source.local.ContactDao
import com.example.adabank.feature_app.data.data_source.local.database.ContactDatabase
import com.example.adabank.feature_app.data.repository.ContactRepositoryImpl
import com.example.adabank.feature_app.domain.repository.ContactRepository
import com.example.adabank.feature_app.domain.usecase.Contact.ClearContactDataUseCase
import com.example.adabank.feature_app.domain.usecase.Contact.GetContactDataUseCase
import com.example.adabank.feature_app.domain.usecase.Contact.UpsertContactDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContactModule {

    @Provides
    @Singleton
    fun getDao(@ApplicationContext context: Context): ContactDao {
        val database = ContactDatabase.createDatabase(context)
        return database.contact
    }

    @Provides
    @Singleton
    fun getRepository(contactDao: ContactDao): ContactRepository {
        return ContactRepositoryImpl(contactDao)
    }

    @Provides
    @Singleton
    fun clearData(contactRepository: ContactRepository): ClearContactDataUseCase {
        return ClearContactDataUseCase(contactRepository)
    }

    @Provides
    @Singleton
    fun getData(contactRepository: ContactRepository): GetContactDataUseCase {
        return GetContactDataUseCase(contactRepository)
    }

    @Provides
    @Singleton
    fun upsertData(contactRepository: ContactRepository): UpsertContactDataUseCase {
        return UpsertContactDataUseCase(contactRepository)
    }
}