package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._F6F6F626opasity15
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity5
import com.example.adabank.feature_app.presentation.ui.theme._FAFAFAopasity50

@Composable
fun CustomAlphaCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .background(_F6F6F626opasity15, RoundedCornerShape(30.dp)),
        colors = CardDefaults.cardColors(_F6F6F626opasity15),
        border = BorderStroke(
            2.dp,
            Brush.linearGradient(listOf(_FAFAFAopasity5, _FAFAFAopasity50))
        ),
        shape = RoundedCornerShape(30.dp)
    ){
        Column(
            modifier = Modifier
                .padding(vertical = 15.dp, horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}