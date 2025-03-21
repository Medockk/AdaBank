package com.example.adabank.feature_app.presentation.Fingerprint

import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FingerprintViewModel : ViewModel() {

    private val _state = mutableStateOf(FingerprintState())
    val state: State<FingerprintState> = _state

    @RequiresApi(Build.VERSION_CODES.P)
    fun onEvent(event: FingerprintEvent) {
        when (event) {
            is FingerprintEvent.SetFingerprint -> {
                BiometricPrompt.Builder(event.value).setTitle("Auth")
                    .setNegativeButton(
                        "cancel",
                        event.value.mainExecutor
                    ) { dialog, which -> }
                    .build().authenticate(
                    CancellationSignal(),
                    event.value.mainExecutor,
                    object : BiometricPrompt.AuthenticationCallback() {
                        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                            super.onAuthenticationSucceeded(result)
                            Log.e("auth", "success")
                        }
                    }
                )
            }
        }
    }
}