package com.easylife.diary.feature.onboarding.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.onboarding.OnBoardingScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 24.12.2022
 */
const val onBoardingRoute = "onboarding_route"

fun NavController.navigateToOnBoarding(navOptions: NavOptions? = null) {
    this.navigate(onBoardingRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.onBoardingScreen(
    navigateToMain: () -> Unit
) {
    composable(route = onBoardingRoute) {
        OnBoardingScreen(
           navigateToMain = {
               navigateToMain()
           }
        ).Create(viewModel = hiltViewModel())
    }
}