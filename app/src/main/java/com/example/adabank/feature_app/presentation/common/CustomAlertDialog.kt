package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_080422
import com.example.adabank.feature_app.presentation.ui.theme.poppins60024Bold_080422

@Composable
fun CustomAlertDialog(
    description: String,
    modifier: Modifier = Modifier,
    title: String = "Ошибка!",
    closeClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = closeClick,
        confirmButton = {},
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = poppins60024Bold_080422
            )
        },
        text = {
            Text(
                text = description,
                style = poppins40012_080422
            )
        },
        containerColor = Color.White,
        icon = {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(_09703E, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    )
}