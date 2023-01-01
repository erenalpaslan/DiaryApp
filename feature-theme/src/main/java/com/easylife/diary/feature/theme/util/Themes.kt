package com.easylife.diary.feature.theme.util

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import com.easylife.diary.core.designsystem.theme.DefaultColorScheme
import com.easylife.diary.core.designsystem.theme.DefaultTypography
import com.easylife.diary.core.designsystem.theme.americanPink
import com.easylife.diary.core.designsystem.theme.black
import com.easylife.diary.core.designsystem.theme.blue
import com.easylife.diary.core.designsystem.theme.lightRed
import com.easylife.diary.core.designsystem.theme.mistyRose
import com.easylife.diary.core.designsystem.theme.oldLace
import com.easylife.diary.core.designsystem.theme.outerSpace
import com.easylife.diary.core.designsystem.theme.pearl
import com.easylife.diary.core.designsystem.theme.white

/**
 * Created by erenalpaslan on 25.12.2022
 */
enum class Themes(val diaryTheme: DiaryTheme) {
    HONEY(
        DiaryTheme(
            id = 1,
            name = "Honey Theme",
            colorScheme = DefaultColorScheme,
            typography = DefaultTypography,
            parentBackgroundColor = pearl
        )
    ),
    DARK(
        DiaryTheme(
            id = 2,
            name = "Dark Theme",
            colorScheme = darkColorScheme(
                primary = blue,
                onPrimary = white,
            ),
            typography = DefaultTypography,
            parentBackgroundColor = outerSpace
        )
    ),
    PINK(
        DiaryTheme(
            id = 3,
            name = "Pink Theme",
            colorScheme = lightColorScheme(
                primary = oldLace,
                onPrimary = black,
                background = lightRed,
                onBackground = black,
                surfaceVariant = mistyRose,
                onSurfaceVariant = white
            ),
            typography = DefaultTypography,
            parentBackgroundColor = americanPink
        )
    );

    companion object {
        infix fun from(id: Int): DiaryTheme? = Themes.values().firstOrNull { it.diaryTheme.id == id }?.diaryTheme
        fun getThemes(): List<DiaryTheme> = Themes.values().map { it.diaryTheme }
    }
}