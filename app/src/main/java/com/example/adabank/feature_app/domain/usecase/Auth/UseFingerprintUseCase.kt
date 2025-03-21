package com.example.adabank.feature_app.domain.usecase.Auth

import com.example.adabank.feature_app.domain.repository.AuthRepository

class UseFingerprintUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke() {
        authRepository.useFingerprint()
    }
}