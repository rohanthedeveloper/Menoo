package com.example.menoo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.menoo.R

// Set of Material typography styles to start with
val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

val Lato = FontFamily(
    Font(R.font.lato_bold),
    Font(R.font.lato_regular),
)

val NunitoSans = FontFamily(
    Font(R.font.nunitosans_bold),
    Font(R.font.nunitosans_regular),
    Font(R.font.nunitosans_semibold),
    Font(R.font.nunitosans_extrabold)
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 120.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge =  TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 48.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Montserrat,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    )

)