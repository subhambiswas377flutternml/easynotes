package com.app.easynotes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aero.notesapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = CustomFontFamily.nunitoSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

class CustomFontFamily{
    companion object{
        val nunitoSansFontFamily: FontFamily = FontFamily(
            androidx.compose.ui.text.font.Font(R.font.nunitosans_black, weight = FontWeight.Black),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_bold, weight = FontWeight.Bold),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_extralight, weight = FontWeight.ExtraLight),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_light, weight = FontWeight.Light),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_semibold, weight = FontWeight.SemiBold),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_extrabold, weight = FontWeight.ExtraBold),
            androidx.compose.ui.text.font.Font(R.font.nunitosans_regular, weight = FontWeight.Normal),
        )
    }
}