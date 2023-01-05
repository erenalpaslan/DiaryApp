package com.easylife.diary.feature.theme.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.themeRoute
import com.easylife.diary.feature.theme.ThemeScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 24.12.2022
 */
fun NavController.navigateToTheme(navOptions: NavOptions? = null) {
    this.navigate(themeRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.themeScreen(
    navigator: DiaryNavigator
) {
    composable(route = themeRoute) {
        ThemeScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}