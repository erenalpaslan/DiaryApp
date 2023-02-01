package com.easylife.diary.feature.insight.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.insightsRoute
import com.easylife.diary.feature.insight.InsightsScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
fun NavController.navigateToInsights(navOptions: NavOptions? = null) {
    this.navigate(insightsRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.insightsScreen(navigator: DiaryNavigator) {
    composable(route = insightsRoute) {
        InsightsScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}