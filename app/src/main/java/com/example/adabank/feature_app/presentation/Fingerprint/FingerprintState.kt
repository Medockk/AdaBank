package com.example.adabank.feature_app.presentation.Fingerprint

import android.content.Context

data class FingerprintState(
    val context: Context? = null,

    val isAuthenticated: Boolean = false,
    val isFingerprintCanceled: Boolean = false,
)
