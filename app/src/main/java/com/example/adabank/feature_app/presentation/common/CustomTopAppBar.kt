@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme.poppins50014_White

@Composable
fun CustomTopAppBar(
    title: String,
    background: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(Color.White),
        modifier = modifier
            .padding(horizontal = 25.dp),
        title = {
            Row {
                Spacer(Modifier.weight(1.5f))
                Text(
                    text = title,
                    style = poppins50014_White.copy(color = background),
                    modifier = Modifier
                )
                Spacer(Modifier.weight(2f))
            }
        },
        navigationIcon = {
            CustomBackIcon(
                background = background,
                onClick = onClick
            )
        },
    )
}