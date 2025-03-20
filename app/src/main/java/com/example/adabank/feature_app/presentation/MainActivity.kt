package com.example.adabank.feature_app.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adabank.feature_app.presentation.Login.LoginScreen
import com.example.adabank.feature_app.presentation.Splash.SplashScreen
import com.example.adabank.feature_app.presentation.ui.theme.AdaBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.decorView.apply {
            this.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
        setContent {
            val navController = rememberNavController()
            AdaBankTheme {
                NavHost(navController, startDestination = Route.SplashScreen.route){
                    composable(Route.SplashScreen.route){
                        SplashScreen(navController)
                    }
                    composable(Route.LoginScreen.route){
                        LoginScreen(navController)
                    }
                }
            }
        }
    }
}