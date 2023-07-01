package com.moview_app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.moview_app.R

private val spogaBold = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)

private val spogaRegular = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)

private val spogaThin = FontFamily(
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = spogaBold,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = spogaBold,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),

    titleSmall = TextStyle(
        fontFamily = spogaBold,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = spogaRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = spogaRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),

    bodySmall = TextStyle(
        fontFamily = spogaRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),

    labelSmall = TextStyle(
        fontFamily = spogaThin,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
    )
)

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = labelMedium.copy(
        textDecoration = TextDecoration.Underline
    )
