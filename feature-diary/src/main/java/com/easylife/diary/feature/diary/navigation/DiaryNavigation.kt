package com.easylife.diary.feature.diary.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.diaryRoute
import com.easylife.diary.feature.diary.DiaryScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */

fun NavController.navigateToDiary(navOptions: NavOptions? = null) {
    this.navigate(diaryRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.diaryScreen(navigator: DiaryNavigator) {
    composable(route = diaryRoute) {
        DiaryScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}