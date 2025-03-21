package com.example.adabank.di

import com.example.adabank.feature_app.data.repository.AuthRepositoryImpl
import com.example.adabank.feature_app.domain.repository.AuthRepository
import com.example.adabank.feature_app.domain.usecase.Auth.SendOtpUseCase
import com.example.adabank.feature_app.domain.usecase.Auth.SetPinCodeUseCase
import com.example.adabank.feature_app.domain.usecase.Auth.UseFingerprintUseCase
import com.example.adabank.feature_app.domain.usecase.Auth.VerifyOtpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun getAuthRepo() : AuthRepository{
        return AuthRepositoryImpl()
    }

    @Provides
    @Singleton
    fun sendOtp(authRepository: AuthRepository) : SendOtpUseCase{
        return SendOtpUseCase(authRepository)
    }
    @Provides
    @Singleton
    fun setPinCode(authRepository: AuthRepository) : SetPinCodeUseCase{
        return SetPinCodeUseCase(authRepository)
    }
    @Provides
    @Singleton
    fun useFingerprint(authRepository: AuthRepository) : UseFingerprintUseCase{
        return UseFingerprintUseCase(authRepository)
    }
    @Provides
    @Singleton
    fun verifyOtp(authRepository: AuthRepository) : VerifyOtpUseCase{
        return VerifyOtpUseCase(authRepository)
    }
}