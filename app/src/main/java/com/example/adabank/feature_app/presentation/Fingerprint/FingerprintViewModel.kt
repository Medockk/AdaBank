package com.example.adabank.feature_app.presentation.Fingerprint

import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.CancellationSignal
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adabank.feature_app.domain.usecase.Auth.UseFingerprintUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FingerprintViewModel @Inject constructor(
    private val useFingerprintUseCase: UseFingerprintUseCase
) : ViewModel() {

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
                    ) { _, _ -> }
                    .build().authenticate(
                    CancellationSignal(),
                    event.value.mainExecutor,
                    object : BiometricPrompt.AuthenticationCallback() {
                        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                            super.onAuthenticationSucceeded(result)

                            viewModelScope.launch(Dispatchers.IO) {
                                val pinCode = useFingerprintUseCase()
                                if (!pinCode.isNullOrBlank()){
                                    Log.e("auth", pinCode)
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}