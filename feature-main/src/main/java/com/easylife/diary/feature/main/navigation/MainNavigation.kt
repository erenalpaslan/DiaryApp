package com.easylife.diary.feature.main.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.main.MainScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 27.12.2022
 */
const val mainRoute = "main_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(mainRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainScreen(
    navigateToTheme: () -> Unit,
    navigateToNote: () -> Unit
) {
    composable(route = mainRoute) {
        MainScreen(
            navigateToTheme = {
                navigateToTheme()
            },
            navigateToNote = {
                navigateToNote()
            }
        ).Create(
            viewModel = hiltViewModel()
        )
    }
}