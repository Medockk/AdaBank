package com.example.adabank.feature_app.presentation.Transfer.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.common.CustomAsyncImage
import com.example.adabank.feature_app.presentation.ui.theme._106048
import com.example.adabank.feature_app.presentation.ui.theme.poppins40010_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50016Bold_080422

@Composable
fun CustomContactCard(
    icon: String,
    name: String,
    bankCardNumber: String,
    index: Int,
    firstVisibleIndex: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        Modifier
            .border(
                1.dp,
                if (index == firstVisibleIndex) _106048 else Color.Transparent,
                RoundedCornerShape(15.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .padding(10.dp)
                .clickable { onClick() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomAsyncImage(icon)
            Spacer(Modifier.height(25.dp))
            Text(
                text = name,
                style = poppins50016Bold_080422
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Bank - $bankCardNumber",
                style = poppins40010_080422opasity50
            )
        }
    }
}