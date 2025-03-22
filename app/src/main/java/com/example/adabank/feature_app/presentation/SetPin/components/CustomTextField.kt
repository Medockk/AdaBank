package com.example.adabank.feature_app.presentation.SetPin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_White

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {

    BasicTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        singleLine = true,
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = PasswordVisualTransformation(),
        decorationBox = {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(4) {
                    CustomBox(
                        char = when{
                            it < value.length -> value[it].toString()
                            else -> "*"
                        }
                    )
                }
            }
        }
    )
}

@Composable
private fun CustomBox(char: String) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(
                SolidColor(_09703E),
                RoundedCornerShape(15.dp),
                if (char == "*") 0.5f else 1f
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "*",
            style = poppins50016Bold_White
        )
    }
}