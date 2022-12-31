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

val DefaultColorScheme = lightColorScheme(
    primary = gold,
    onPrimary = black,
    secondary = white,
    tertiary = outerSpace,
    background = alabaster,
    onBackground = gray,
    surface = alabaster,
    onSurface = outerSpace,
    surfaceVariant = white,
    onSurfaceVariant = gray
)