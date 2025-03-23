package com.example.adabank.feature_app.presentation.Notification

import com.example.adabank.feature_app.domain.model.CompleteVerification
import com.example.adabank.feature_app.domain.model.Notifications

data class NotificationState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val notifications: List<Notifications> = emptyList(),
    val completeVerification: List<CompleteVerification> = emptyList(),
    val completeVerificationPercent: String = "60",
)
