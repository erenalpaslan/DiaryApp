package com.easylife.diary.feature.theme.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.theme.ThemeScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 24.12.2022
 */
const val themeRoute = "theme_route"

fun NavController.navigateToTheme(navOptions: NavOptions? = null) {
    this.navigate(themeRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.themeScreen(
    navigateToMain: () -> Unit
) {
    composable(route = themeRoute) {
        ThemeScreen(
           navigateToMain = {
               navigateToMain()
           }
        ).Create(viewModel = hiltViewModel())
    }
}