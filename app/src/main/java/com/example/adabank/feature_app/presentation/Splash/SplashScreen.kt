package com.example.adabank.feature_app.presentation.Splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFA0D
import com.example.adabank.feature_app.presentation.ui.theme.poppins40014_080422
import com.example.adabank.feature_app.presentation.ui.theme.poppins60024Bold_080422

@Composable
fun SplashScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_106048)
            .padding(top = 35.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.splash_bubles),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )
            Image(
                painter = painterResource(R.drawable.splash_icon),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
                    .padding(horizontal = 40.dp)
            )
        }
        Spacer(Modifier.weight(1f))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(_F6F6F6, RoundedCornerShape(30.dp)),
            colors = CardDefaults.cardColors(_F6F6F6),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(3.dp, Brush.linearGradient(listOf(_FAFAFA0D, Color.White)))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 40.dp, bottom = 30.dp,
                        start = 40.dp, end = 40.dp,
                    )
            ) {
                Text(
                    text = "Start payments easily \n" +
                            "in the digital age",
                    style = poppins60024Bold_080422
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Payment tool that is easy and fast to use in this easy-to-use digital era. Use the features that make your business easier",
                    style = poppins40014_080422
                )

                Spacer(Modifier.height(40.dp))

                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .background(_09703E, CircleShape),
                    colors = CardDefaults.cardColors(_09703E),
                    onClick = {
                        navController.navigate(Route.LoginScreen.route){
                            popUpTo(Route.SplashScreen.route){
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}