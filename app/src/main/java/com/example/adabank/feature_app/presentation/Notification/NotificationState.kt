package com.example.adabank.feature_app.presentation.Notification

import com.example.adabank.feature_app.domain.model.Notifications

data class NotificationState(
    val exception: String = "",
    val showIndicator: Boolean = false,

    val notifications: List<Notifications> = emptyList(),
)
