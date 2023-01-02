package com.easylife.diary.feature.main.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.easylife.diary.feature.calendar.navigation.calendarScreen
import com.easylife.diary.feature.diary.navigation.diaryRoute
import com.easylife.diary.feature.diary.navigation.diaryScreen
import com.easylife.diary.feature.insight.navigation.insightsScreen
import com.easylife.diary.feature.theme.navigation.navigateToTheme
import com.easylife.diary.feature.theme.navigation.themeScreen
import com.github.feature.setting.navigation.settingsScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

/**
 * Created by erenalpaslan on 1.01.2023
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    navigateToTheme: () -> Unit
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = diaryRoute,
        modifier = Modifier.padding(paddingValues)
    ) {
        diaryScreen()
        calendarScreen()
        insightsScreen()
        settingsScreen(
            navigateToTheme = {
                navigateToTheme()
            }
        )
        themeScreen {
            navController.popBackStack()
        }
    }
}
