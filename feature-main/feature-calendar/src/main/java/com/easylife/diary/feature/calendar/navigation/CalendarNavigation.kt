package com.easylife.diary.feature.calendar.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.calendar.CalendarScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
const val calendarRoute = "calendar_route"

fun NavController.navigateToCalendar(navOptions: NavOptions? = null) {
    this.navigate(calendarRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.calendarScreen() {
    composable(route = calendarRoute) {
        CalendarScreen().Create(viewModel = hiltViewModel())
    }
}