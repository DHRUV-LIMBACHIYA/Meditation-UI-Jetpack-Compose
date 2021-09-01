package com.example.meditationui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.meditationui.R

val gothicA1 = FontFamily(
    listOf(
        Font(R.font.nunito_regular, FontWeight.Normal),
        Font(R.font.nunito_semibold, FontWeight.SemiBold),
        Font(R.font.nunito_bold, FontWeight.Bold),
    )
)


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = AquaBlue,
        fontSize = 14.sp,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Normal
    ),
    h1 =  TextStyle(
        color = TextWhite,
        fontSize = 22.sp,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold
    ),
    h2 = TextStyle(
        color = TextWhite,
        fontSize = 18.sp,
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold
    ),
    h4 = TextStyle(
        color = TextWhite,
        fontSize = 14.sp,
        fontFamily = gothicA1,
        fontWeight = FontWeight.SemiBold
    )

)