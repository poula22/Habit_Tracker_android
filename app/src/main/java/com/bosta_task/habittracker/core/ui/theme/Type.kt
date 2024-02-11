package com.bosta_task.habittracker.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bosta_task.habittracker.R

// Set of Material typography styles to start with
val klasik = FontFamily(
    Font(
        resId = R.font.klasik_regular,
        weight = FontWeight.Bold
    ),
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = klasik,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        color = Eclipse,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = klasik,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        color = Eclipse,
        letterSpacing = 0.sp
    )
)