package com.easylife.diary.delete.data.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import com.easylife.diary.delete.data.DeleteDataScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 6.01.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.deleteDataScreen(
    navigator: DiaryNavigator
) {
    composable(DiaryRoutes.deleteDataRoute) {
        DeleteDataScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}