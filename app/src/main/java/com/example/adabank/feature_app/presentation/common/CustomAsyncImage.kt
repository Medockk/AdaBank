package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CustomAsyncImage(
    model: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = model,
        contentDescription = null,
        modifier = modifier
            .size(55.dp)
            .clip(RoundedCornerShape(15.dp)),
        contentScale = ContentScale.Crop
    )
}