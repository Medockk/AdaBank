package com.example.adabank.feature_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adabank.feature_app.presentation.Fingerprint.FingerprintScreen
import com.example.adabank.feature_app.presentation.Home.HomeScreen
import com.example.adabank.feature_app.presentation.Login.LoginScreen
import com.example.adabank.feature_app.presentation.Notification.NotificationScreen
import com.example.adabank.feature_app.presentation.SetPin.SetPinScreen
import com.example.adabank.feature_app.presentation.Splash.SplashScreen
import com.example.adabank.feature_app.presentation.TopUpWallet.TopUpWalletScreen
import com.example.adabank.feature_app.presentation.ui.theme.AdaBankTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AdaBankTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    NavHost(
                        navController,
                        startDestination = Route.SplashScreen.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(Route.SplashScreen.route) {
                            SplashScreen(navController)
                        }
                        composable(Route.LoginScreen.route) {
                            LoginScreen(navController)
                        }
                        composable(Route.SetPinScreen.route) {
                            SetPinScreen(navController)
                        }
                        composable(Route.FingerprintScreen.route) {
                            FingerprintScreen(navController)
                        }


                        composable(Route.HomeScreen.route){
                            HomeScreen(navController)
                        }
                        composable(Route.TopUpWalletScreen.route){
                            TopUpWalletScreen(navController)
                        }
                        composable(Route.NotificationScreen.route){
                            NotificationScreen(navController)
                        }
                    }
                }
            }
        }
    }
}