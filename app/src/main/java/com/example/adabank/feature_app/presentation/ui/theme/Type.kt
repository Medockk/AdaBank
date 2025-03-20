package com.example.adabank.feature_app.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.adabank.R

val poppinsRegular = FontFamily(Font(R.font.poppins_regular))
val poppinsBold = FontFamily(Font(R.font.poppins_bold))

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)

val poppins60024Bold_080422 = TextStyle(
    fontFamily = poppinsBold,
    fontWeight = FontWeight(600),
    fontSize = 24.sp,
    textAlign = TextAlign.Center,
    color = _080422
)
val poppins40014_080422 = TextStyle(
    fontFamily = poppinsRegular,
    fontWeight = FontWeight(400),
    fontSize = 14.sp,
    textAlign = TextAlign.Center,
    color = _080422
)
val poppins40012_080422 = TextStyle(
    fontFamily = poppinsRegular,
    fontWeight = FontWeight(400),
    fontSize = 12.sp,
    textAlign = TextAlign.Center,
    color = _080422
)
val poppins50032Bold_09703E = TextStyle(
    fontFamily = poppinsBold,
    fontWeight = FontWeight(500),
    fontSize = 32.sp,
    textAlign = TextAlign.Center,
    color = _09703E
)
val poppins50026Bold_09703E = TextStyle(
    fontFamily = poppinsBold,
    fontWeight = FontWeight(500),
    fontSize = 26.sp,
    textAlign = TextAlign.Center,
    color = _09703E
)
val poppins50016Bold_White = TextStyle(
    fontFamily = poppinsBold,
    fontWeight = FontWeight(500),
    fontSize = 16.sp,
    textAlign = TextAlign.Center,
    color = Color.White
)
val poppins60032Bold_Black = TextStyle(
    fontFamily = poppinsBold,
    fontWeight = FontWeight(600),
    fontSize = 32.sp,
    textAlign = TextAlign.Center,
    color = Color.Black
)