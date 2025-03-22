package com.example.adabank.feature_app.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F6

@Composable
fun CustomIndicator(
    showIndicator: Boolean,
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    AnimatedVisibility(
        visible = showIndicator,
        enter = fadeIn(tween(500)),
        exit = fadeOut(tween(500))
    ) {
        Box(
            modifier = modifier
                .background(
                    Brush.linearGradient(listOf(_F6F6F6, _F6F6F6)),
                    alpha = 0.3f
                ),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = _09703E,
            )
        }
    }
}