package com.example.adabank.feature_app.domain.usecase.Auth

import com.example.adabank.feature_app.domain.repository.AuthRepository

class SendOtpUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(phone: String){
        authRepository.sendOtp(phone)
    }
}