package com.example.adabank.feature_app.presentation.Menu

sealed class MenuEvent {

    data class EnterSearchText(val value: String) : MenuEvent()
}