package com.example.adabank.feature_app.presentation.TopUpWallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.common.CustomTopAppBar
import com.example.adabank.feature_app.presentation.ui.theme._080422

@Composable
fun TopUpWalletScreen(
    navController: NavController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
    CustomTopAppBar(
        title = "Top-up Wallet",
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        background = _080422
    ) { navController.popBackStack() }
}