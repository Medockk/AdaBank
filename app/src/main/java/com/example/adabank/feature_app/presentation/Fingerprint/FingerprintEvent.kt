package com.example.adabank.feature_app.presentation.Fingerprint

import android.content.Context

sealed class FingerprintEvent {

    data class SetFingerprint(val value: Context) : FingerprintEvent()
}