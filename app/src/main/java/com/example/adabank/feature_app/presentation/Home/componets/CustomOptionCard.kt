package com.example.adabank.feature_app.presentation.Home.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._130F26
import com.example.adabank.feature_app.presentation.ui.theme._E9FFAB
import com.example.adabank.feature_app.presentation.ui.theme.poppins40012_White

@Composable
fun CustomOptionCard(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            colors = CardDefaults.cardColors(_E9FFAB),
            shape = RoundedCornerShape(20.dp),
            onClick = onClick
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = _130F26,
                modifier = Modifier
                    .padding(15.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = title,
            style = poppins40012_White
        )
    }
}