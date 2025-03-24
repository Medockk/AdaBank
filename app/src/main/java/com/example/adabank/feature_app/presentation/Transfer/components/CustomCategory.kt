package com.example.adabank.feature_app.presentation.Transfer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Whiteopasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50012_White

@Composable
fun CustomCategory(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { onClick() }
    ) {
        if (isSelected) {
            Box(
                Modifier
                    .size(32.dp)
                    .border(1.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(Modifier
                    .size(20.dp)
                    .background(Color.White, CircleShape))
            }
        } else {
            Box(Modifier
                .size(20.dp)
                .alpha(0.5f)
                .background(Color.White, CircleShape))
        }
        Spacer(Modifier.height(5.dp))
        Text(
            text = text,
            style = if (isSelected) poppins50012_White else poppins40012_Whiteopasity50
        )
    }
}