package com.github.feature.setting.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.settingsRoute
import com.easylife.diary.delete.data.navigation.deleteDataScreen
import com.easylife.diary.password.navigation.passwordScreen
import com.github.feature.setting.SettingsScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 1.01.2023
 */
fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate(settingsRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsScreen(
    navigator: DiaryNavigator
) {
    composable(route = settingsRoute) {
        SettingsScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
    passwordScreen(navigator)
    deleteDataScreen(navigator)
}