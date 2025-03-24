package com.example.adabank.feature_app.presentation

import com.example.adabank.feature_app.domain.model.Contact

sealed class Route(val route: String) {

    data object SplashScreen : Route("SplashScreen")
    data object LoginScreen : Route("LoginScreen")
    data object SetPinScreen : Route("SetPinScreen")
    data object FingerprintScreen : Route("FingerprintScreen")

    data object HomeScreen : Route("HomeScreen")
    data object NotificationScreen : Route("NotificationScreen")
    data object TopUpWalletScreen : Route("TopUpWalletScreen")
    data object MenuScreen : Route("MenuScreen")

    data object TransferScreen : Route("TransferScreen")
    data object TransferDetailScreen : Route("TransferDetailScreen"){
        var contact = Contact(0,"","","", "")
    }
    data object ReceiptScreen : Route("ReceiptScreen")
}