@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.adabank.feature_app.presentation.Login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422opasity20
import com.example.adabank.feature_app.presentation.ui.theme.poppins40023White
import com.example.adabank.feature_app.presentation.ui.theme.poppins60012Bold_White
import com.example.adabank.feature_app.presentation.ui.theme.poppins60024Bold_080422

@Composable
fun CustomBottomSheet(
    text: String,
    state: SheetState,
    value: String,
    onValueChange: (String) -> Unit,
    resendCodeText: String,
    restartTimer: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onDismissRequest: () -> Unit = {}
) {
    ModalBottomSheet(
        sheetState = state,
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        containerColor = _F6F6F6,
        shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Verification Code",
                style = poppins60024Bold_080422
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "We have sent the code verification to\n" +
                        "your mobile number. Wrong number ?",
                style = poppins40012_080422opasity20
            )
            Spacer(Modifier.height(20.dp))
            Box(Modifier.background(_09703E, RoundedCornerShape(36.dp))) {
                Text(
                    text = text,
                    style = poppins60012Bold_White,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
            Spacer(Modifier.height(45.dp))
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(4) {
                            CustomBox(
                                char = when {
                                    it < value.length -> value[it].toString()
                                    else -> ""
                                }
                            )
                        }
                    }
                }
            )
            Spacer(Modifier.height(35.dp))
            Text(
                text = "Resend Code in 00:${if (resendCodeText != "9") {
                        resendCodeText
                    } else {
                        "0$resendCodeText"
                    }
                }",
                style = poppins40012_080422opasity20,
                modifier = if (resendCodeText == "0"){Modifier
                    .clickable {
                        restartTimer()
                    }}else{Modifier}
            )
            Spacer(Modifier.height(35.dp))
        }
    }
}

@Composable
private fun CustomBox(char: String) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(
                SolidColor(_09703E),
                RoundedCornerShape(15.dp),
                if (char.isBlank()) 0.5f else 1f
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = char,
            style = poppins40023White
        )
    }
}