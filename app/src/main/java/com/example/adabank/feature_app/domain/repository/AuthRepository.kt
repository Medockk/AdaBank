package com.example.adabank.feature_app.domain.repository

interface AuthRepository {

    suspend fun sendOtp(phone: String)
    suspend fun verifyOtp(phone: String, otp: String)
    suspend fun setPinCode(pinCode: String)

    suspend fun useFingerprint() : String?
    suspend fun isUserRegistration() :Boolean
}