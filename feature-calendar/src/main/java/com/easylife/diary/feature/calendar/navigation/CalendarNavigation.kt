package com.easylife.diary.feature.calendar.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.calendarRoute
import com.easylife.diary.feature.calendar.CalendarScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
fun NavController.navigateToCalendar(navOptions: NavOptions? = null) {
    this.navigate(calendarRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.calendarScreen(navigator: DiaryNavigator) {
    composable(route = calendarRoute) {
        CalendarScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}