package com.easylife.diary.core.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DefaultColorScheme = lightColorScheme(
    primary = gold,
    secondary = white,
    tertiary = outerSpace,
    onPrimary = white,
    background = alabaster,
    surface = alabaster,
    onSurface = outerSpace,
    surfaceVariant = white,
)

//TODO: Main neeeds to handle changes of colorscheme
// by observing theme changes by user
@Composable
fun DiaryTheme(
    colorScheme: ColorScheme = DefaultColorScheme,
    typography: Typography = DefaultTypography,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}