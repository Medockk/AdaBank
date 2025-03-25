package com.example.adabank.feature_app.presentation.Home.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.adabank.feature_app.presentation.ui.theme._07041A17
import com.example.adabank.feature_app.presentation.ui.theme.poppins40010_080422opasity50
import com.example.adabank.feature_app.presentation.ui.theme.poppins50012Bold_080422

@Composable
fun CustomTransactionHistory(
    image: String,
    title: String,
    date: String,
    price: String,
    sendTo: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(12.dp))
                .shadow(2.dp, RoundedCornerShape(12.dp), spotColor = _07041A17),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(Color.White),
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
        Spacer(Modifier.width(15.dp))
        Column {
            Text(
                text = title,
                style = poppins50012Bold_080422
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = date,
                style = poppins40010_080422opasity50
            )
        }
        Spacer(Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$$price",
                style = poppins50012Bold_080422
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = sendTo,
                style = poppins40010_080422opasity50
            )
        }
    }
}