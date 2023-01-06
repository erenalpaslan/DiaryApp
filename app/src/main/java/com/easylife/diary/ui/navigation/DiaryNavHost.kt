package com.easylife.diary.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.splashRoute
import com.easylife.diary.feature.calendar.navigation.calendarScreen
import com.easylife.diary.feature.diary.navigation.diaryScreen
import com.easylife.diary.feature.insight.navigation.insightsScreen
import com.easylife.diary.feature.note.navigation.noteScreen
import com.easylife.diary.feature.splash.navigation.splashScreen
import com.easylife.diary.feature.theme.navigation.themeScreen
import com.github.feature.setting.navigation.settingsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DiaryNavHost(
    navigator: DiaryNavigator,
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = splashRoute,
        modifier = Modifier.windowInsetsPadding(
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal
            )
        )
    ) {
        splashScreen(navigator)
        themeScreen(navigator)
        noteScreen(navigator)
        diaryScreen(navigator)
        calendarScreen(navigator)
        insightsScreen(navigator)
        settingsScreen(navigator)
    }
}