package com.example.adabank.feature_app.domain.usecase.Auth

import com.example.adabank.feature_app.domain.repository.AuthRepository

class IsUserRegistrationUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke() : Boolean{
        return authRepository.isUserRegistration()
    }
}