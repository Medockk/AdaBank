package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._080422

@Composable
fun CustomBackIcon(
    modifier: Modifier = Modifier,
    background: Color = _080422,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(27.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(background, RoundedCornerShape(5.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = null,
            tint = if (background == _080422) Color.White else _080422,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}