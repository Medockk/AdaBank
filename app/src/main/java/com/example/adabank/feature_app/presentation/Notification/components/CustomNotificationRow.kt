package com.example.adabank.feature_app.presentation.Notification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.adabank.feature_app.presentation.ui.theme._09703E
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Black
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_Blackopasity50

@Composable
fun CustomNotificationRow(
    leadingIcon: String,
    title: String,
    description: String,
    trailingIcon: ImageVector = Icons.Default.Close,
    trailingIconColor: Color = _09703E,
) {
    Spacer(
        Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
            .alpha(0.1f)
    )
    Spacer(Modifier.height(15.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = leadingIcon,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(Modifier.weight(1f))
        Column {
            Text(
                text = title,
                style = poppins40012_Black
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = description,
                style = poppins40012_Blackopasity50
            )
        }
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = trailingIcon,
            contentDescription = null,
            tint = trailingIconColor
        )
    }
}