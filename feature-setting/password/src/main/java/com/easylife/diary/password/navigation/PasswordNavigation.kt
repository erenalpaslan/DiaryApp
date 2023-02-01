package com.easylife.diary.password.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import com.easylife.diary.password.PasswordScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 6.01.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.passwordScreen(
    navigator: DiaryNavigator
) {
    composable(route = DiaryRoutes.passwordRoute) {
        PasswordScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}
