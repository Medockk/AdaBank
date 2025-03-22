package com.example.adabank.feature_app.data.repository

import android.content.Context
import com.example.adabank.feature_app.data.data_source.Supabase.client
import com.example.adabank.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.OtpType
import io.github.jan.supabase.auth.auth

class AuthRepositoryImpl(
    private val context: Context
) : AuthRepository {

    private val pinCodeKey = "PinCodeKey"
    private val isUserRegistered = "IsUserRegistered"
    private val sp = context.getSharedPreferences(pinCodeKey, Context.MODE_PRIVATE)

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
        sp.edit().clear().putString(pinCodeKey, pinCode).putBoolean(isUserRegistered, true).apply()
    }

    override suspend fun useFingerprint() : String? {
        return sp.getString(pinCodeKey, "")
    }

    override suspend fun isUserRegistration(): Boolean {
        return sp.getBoolean(isUserRegistered, false)
    }
}