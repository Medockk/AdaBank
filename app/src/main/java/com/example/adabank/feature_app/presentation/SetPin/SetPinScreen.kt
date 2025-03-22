package com.example.adabank.feature_app.presentation.SetPin

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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.SetPin.components.CustomTextField
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomBackIcon
import com.example.adabank.feature_app.presentation.common.CustomKeyboard
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins60032Bold_Black

@Composable
fun SetPinScreen(
    navController: NavController,
    viewModel: SetPinViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(SetPinEvent.ResetException)
        }
    }
    LaunchedEffect(!state.isComplete) {
        if (state.isComplete) {
            navController.navigate(Route.FingerprintScreen.route)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_F6F6F6)
            .padding(
                top = (LocalConfiguration.current.screenHeightDp / 30).dp,
                start = 25.dp,
                end = 25.dp,
                bottom = 10.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomBackIcon(
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            navController.popBackStack()
        }
        Spacer(Modifier.height(60.dp))
        Text(
            text = "Set your PIN",
            style = poppins60032Bold_Black
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "You will get use this to login next time",
            style = poppins40012_080422opasity20
        )
        Spacer(Modifier.height(60.dp))
        CustomTextField(
            value = state.pin,
            onValueChange = { viewModel.onEvent(SetPinEvent.SetPin(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(Modifier.weight(1f))
        CustomKeyboard(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth(),
            onNumberClick = { column, row ->
                viewModel.onEvent(
                    SetPinEvent.SetPin(
                        when (column) {
                            0 -> {
                                state.pin + "${row + 1}"
                            }

                            1 -> {
                                state.pin + "${row + 4}"
                            }

                            else -> {
                                state.pin + "${row + 7}"
                            }
                        }
                    )
                )
            },
            zeroClick = {
                viewModel.onEvent(SetPinEvent.SetPin(state.pin + "0"))
            },
            deleteClick = {
                viewModel.onEvent(SetPinEvent.DeletePinCharacter)
            },
        ) {
            viewModel.onEvent(SetPinEvent.NextClick)
        }
    }
}