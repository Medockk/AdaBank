package com.example.adabank.feature_app.data.repository

import com.example.adabank.feature_app.data.data_source.Supabase.client
import com.example.adabank.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.OtpType
import io.github.jan.supabase.auth.auth

class AuthRepositoryImpl : AuthRepository {

    override suspend fun sendOtp(phone: String) {
        //like work :/
    }

    override suspend fun verifyOtp(phone: String, otp: String) {
        client.auth.verifyPhoneOtp(
            type = OtpType.Phone.SMS,
            phone = phone,
            token = otp
        )
    }

    override suspend fun setPinCode(pinCode: String) {
        TODO("Not yet implemented")
    }

    override suspend fun useFingerprint() {
        TODO("Not yet implemented")
    }
}