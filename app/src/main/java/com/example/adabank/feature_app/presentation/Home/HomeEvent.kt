package com.example.adabank.feature_app.presentation.Home

sealed class HomeEvent {

    data object ResetException : HomeEvent()

}