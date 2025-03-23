package com.example.adabank.feature_app.presentation.Menu.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._E9FFAB
import com.example.adabank.feature_app.presentation.ui.theme.poppins40014White

@Composable
fun CustomMenuCard(
    icon: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onClick() }
    ) {
        Card(
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(_E9FFAB),
            onClick = onClick
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(13.dp)
            )
        }
        Spacer(Modifier.width(15.dp))
        Text(
            text = text,
            style = poppins40014White
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.White
        )
    }
}