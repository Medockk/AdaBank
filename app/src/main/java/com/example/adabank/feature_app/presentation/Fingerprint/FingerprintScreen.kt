package com.example.adabank.feature_app.presentation.Fingerprint

import android.os.Build
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomBackIcon
import com.example.adabank.feature_app.presentation.common.CustomButton
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins60024Bold_080422

@Composable
fun FingerprintScreen(
    navController: NavController,
    viewModel: FingerprintViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val state = viewModel.state.value

    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Log.e("auth", "auth")
            viewModel.onEvent(FingerprintEvent.SetFingerprint(context))
        }
    }

    LaunchedEffect(!state.isAuthenticated) {
        if (state.isAuthenticated) {
            navController.navigate(Route.HomeScreen.route) {
                popUpTo(Route.FingerprintScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(!state.isFingerprintCanceled) {
        if (state.isFingerprintCanceled) {
            navController.navigate(Route.SetPinScreen.route) {
                popUpTo(Route.FingerprintScreen.route) {
                    inclusive = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_F6F6F6)
            .padding(
                horizontal = 25.dp,
                vertical = (LocalConfiguration.current.screenHeightDp / 30).dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomBackIcon(
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            navController.popBackStack()
        }

        Spacer(Modifier.height(50.dp))
        Image(
            painter = painterResource(R.drawable.fingerprint),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.weight(1f))

        Text(
            text = "Use Touch ID to\n" +
                    "authorise paymentts",
            style = poppins60024Bold_080422
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Active touch ID so you don’t need to confirm  \n" +
                    "your PIN every time you want to send money",
            style = poppins40012_080422opasity20
        )

        Spacer(Modifier.weight(1f))
        CustomButton(
            text = "Finish",
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
        ) {
            navController.navigate(Route.HomeScreen.route){
                popUpTo(Route.FingerprintScreen.route){
                    inclusive = true
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        CustomButton(
            text = "Skip",
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .alpha(0.5f)
        ) {
            navController.navigate(Route.HomeScreen.route){
                popUpTo(Route.FingerprintScreen.route){
                    inclusive = true
                }
            }
        }
    }
}