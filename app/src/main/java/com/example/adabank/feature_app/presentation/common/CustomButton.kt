package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_White
//привет сенечка
//как дела?????
//что делаешь???
//что кушал???
//как поспал??
//я надеюсь ты меня не убъешь за это <3 мы любя
@Composable
fun CustomButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = _09703E,
            disabledContainerColor = _09703E
        ),
        shape = RoundedCornerShape(36.dp)
    ) {
        Text(
            text = text,
            style = poppins50016Bold_White
        )
    }
}