package com.example.adabank.feature_app.presentation.Notification

sealed class NotificationEvent {

    data object ResetException : NotificationEvent()
}