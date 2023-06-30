package com.moview_app.ui.config

import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import com.moview_app.ui.theme.color.ColorSet

data class ComponentConfig(
    val colors: ColorSet,
    val typography: Typography,
    val shapes: Shapes,
    val isDarkTheme: Boolean
)