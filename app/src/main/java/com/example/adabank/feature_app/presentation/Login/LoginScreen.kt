@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.adabank.feature_app.presentation.Login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.adabank.R
import com.example.adabank.feature_app.presentation.Login.components.CustomBottomSheet
import com.example.adabank.feature_app.presentation.Route
import com.example.adabank.feature_app.presentation.common.CustomAlertDialog
import com.example.adabank.feature_app.presentation.common.CustomIndicator
import com.example.adabank.feature_app.presentation.common.CustomKeyboard
import com.example.adabank.feature_app.presentation.ui.theme._080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422
import com.example.adabank.feature_app.presentation.ui.theme.poppins40016_080422
import com.example.adabank.feature_app.presentation.ui.theme.poppins50032Bold_09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins60032Bold_Black

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val drawerSheetState = rememberModalBottomSheetState(confirmValueChange = {false})

    LaunchedEffect(!state.isSendOtp) {
        if (state.isSendOtp) {
            viewModel.onEvent(LoginEvent.StartResendTimer)
            drawerSheetState.show()
        }
    }

    LaunchedEffect(!state.isComplete) {
        if (state.isComplete){
            drawerSheetState.hide()
            navController.navigate(Route.SetPinScreen.route)
            viewModel.onEvent(LoginEvent.EnterOtpCode(""))
        }
    }

    if (state.exception.isNotEmpty()) {
        CustomAlertDialog(state.exception) {
            viewModel.onEvent(LoginEvent.ResetException)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(_F6F6F6)
            .padding(
                top = (LocalConfiguration.current.screenHeightDp / 15).dp,
                start = 25.dp,
                end = 25.dp,
                bottom = 15.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.logo_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = "AdaBank",
                style = poppins50032Bold_09703E
            )
        }
        Spacer(Modifier.height(40.dp))
        Text(
            text = "Welcome",
            style = poppins60032Bold_Black
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Enter your mobile number  for Continue",
            style = poppins40012_080422
        )
        Spacer(Modifier.height(40.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextField(
                value = state.countyPhoneCode,
                onValueChange = {},
                modifier = Modifier
                    .widthIn(70.dp, 95.dp),
                singleLine = true,
                enabled = false,
                colors = TextFieldDefaults.colors(
                    disabledTextColor = _080422opasity20,
                    disabledContainerColor = Color.Transparent,
                    disabledIndicatorColor = _080422opasity20
                ),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = _080422opasity20,
                        modifier = Modifier
                            .clickable { }
                    )
                }
            )
            Spacer(Modifier.width(15.dp))
            TextField(
                value = state.phone,
                onValueChange = {
                    viewModel.onEvent(LoginEvent.EnterPhone(it))
                },
                textStyle = poppins40016_080422.copy(textAlign = TextAlign.Left),
                modifier = Modifier
                    .weight(1f),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = _09703E,
                    unfocusedIndicatorColor = _080422opasity20,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
        }

        Spacer(Modifier.weight(1f))

        CustomKeyboard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(15.dp),
            onNumberClick = { column, row ->
                viewModel.onEvent(
                    LoginEvent.EnterPhone(
                        when (column) {
                            0 -> {
                                state.phone + "${row + 1}"
                            }

                            1 -> {
                                state.phone + "${row + 4}"
                            }

                            else -> {
                                state.phone + "${row + 7}"
                            }
                        }
                    )
                )
            },
            zeroClick = {
                viewModel.onEvent(LoginEvent.EnterPhone(state.phone + "0"))
            },
            deleteClick = {
                viewModel.onEvent(LoginEvent.DeletePhoneCharacter)
            },
            onBtnClick = {
                viewModel.onEvent(LoginEvent.Login)
            },
            enabled = !state.showIndicator
        )
    }

    AnimatedVisibility(
        visible = state.isSendOtp,
    ) {
        CustomBottomSheet(
            text = state.countyPhoneCode+state.phone,
            state = drawerSheetState,
            value = state.otpCode,
            onValueChange = {
                viewModel.onEvent(LoginEvent.EnterOtpCode(it))
            },
            enabled = !state.showIndicator,
            resendCodeText = state.resendCodeTime,
            restartTimer = { viewModel.onEvent(LoginEvent.StartResendTimer) }
        )
    }

    CustomIndicator(state.showIndicator)
}