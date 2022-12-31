package com.easylife.diary.feature.theme.util

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color

/**
 * Created by erenalpaslan on 24.12.2022
 */
data class DiaryTheme(
    val id: Int,
    val name: String,
    val colorScheme: ColorScheme,
    val typography: Typography,
    val parentBackgroundColor: Color,
    val backgroundImage: Int? = null,
    val smallBackgroundImage: Int? = null,
    val isPremium: Boolean = false,
    val isApplied: Boolean = false
)
