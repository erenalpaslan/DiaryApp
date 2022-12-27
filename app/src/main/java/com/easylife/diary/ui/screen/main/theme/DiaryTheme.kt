package com.easylife.diary.ui.screen.main.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import com.easylife.diary.core.designsystem.theme.DefaultColorScheme
import com.easylife.diary.core.designsystem.theme.DefaultTypography
import com.easylife.diary.feature.theme.util.Theme

@Composable
fun DiaryTheme(
    theme: Theme? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = theme?.colorScheme ?: DefaultColorScheme,
        typography = theme?.typography ?: DefaultTypography,
        content = content
    )
}