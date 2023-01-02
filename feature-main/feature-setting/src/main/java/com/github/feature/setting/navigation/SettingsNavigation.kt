package com.github.feature.setting.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.github.feature.setting.SettingsScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
const val settingsRoute = "settings_route"

fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate(settingsRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsScreen(
    navigateToTheme: () -> Unit
) {
    composable(route = settingsRoute) {
        SettingsScreen(
            navigateToTheme = {
                navigateToTheme()
            }
        ).Create(viewModel = hiltViewModel())
    }
}