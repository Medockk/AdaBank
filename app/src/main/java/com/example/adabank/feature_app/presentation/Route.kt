package com.example.adabank.feature_app.presentation

sealed class Route(val route: String) {

    data object SplashScreen : Route("SplashScreen")
    data object LoginScreen : Route("LoginScreen")
    data object SetPinScreen : Route("SetPinScreen")
    data object FingerprintScreen : Route("FingerprintScreen")
}