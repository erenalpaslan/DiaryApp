package com.easylife.diary.feature.diary.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.diary.DiaryScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
const val diaryRoute = "diary_route"

fun NavController.navigateToDiary(navOptions: NavOptions? = null) {
    this.navigate(diaryRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.diaryScreen() {
    composable(route = diaryRoute) {
        DiaryScreen().Create(viewModel = hiltViewModel())
    }
}