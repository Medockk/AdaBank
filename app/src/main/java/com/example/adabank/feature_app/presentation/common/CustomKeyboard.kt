package com.example.adabank.feature_app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.adabank.feature_app.presentation.ui.theme._080422
import com.example.adabank.feature_app.presentation.ui.theme.poppins50026Bold_080422

@Composable
fun CustomKeyboard(
    modifier: Modifier = Modifier,
    onNumberClick: (Int, Int) -> Unit,
    zeroClick: () -> Unit,
    deleteClick: () -> Unit,
    btnText: String = "Next",
    enabled: Boolean = true,
    onBtnClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(3) { column ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(3) { row ->
                    TextButton(
                        onClick = {
                            onNumberClick(column, row)
                        },
                        shape = CircleShape
                    ) {
                        Text(
                            text = when (column) {
                                0 -> {
                                    "${row + 1}"
                                }

                                1 -> {
                                    "${row + 4}"
                                }

                                else -> {
                                    "${row + 7}"
                                }
                            },
                            style = poppins50026Bold_080422,
                        )
                    }
                    if (row != 2) {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(2) {
                TextButton(
                    onClick = zeroClick,
                    shape = CircleShape
                ) {
                    Text(
                        text = when (it) {
                            0 -> {
                                "."
                            }

                            else -> {
                                "0"
                            }
                        },
                        style = poppins50026Bold_080422
                    )
                }
                Spacer(Modifier.weight(1f))
            }

            TextButton(
                onClick = deleteClick,
                shape = CircleShape
            ) {
                Box(
                    Modifier
                        .clip(CircleShape)
                        .background(_080422, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        CustomButton(
            text = btnText,
            enabled = enabled,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            onClick = onBtnClick
        )
    }
}