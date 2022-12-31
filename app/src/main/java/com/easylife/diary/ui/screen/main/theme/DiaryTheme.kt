package com.easylife.diary.ui.screen.main.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.easylife.diary.core.designsystem.theme.DefaultColorScheme
import com.easylife.diary.core.designsystem.theme.DefaultTypography
import com.easylife.diary.feature.theme.util.DiaryTheme

@Composable
fun DiaryTheme(
    diaryTheme: DiaryTheme? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = diaryTheme?.colorScheme ?: DefaultColorScheme,
        typography = diaryTheme?.typography ?: DefaultTypography,
        content = content
    )
}