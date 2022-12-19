package com.easylife.diary.ui.screen.onboarding

import androidx.navigation.NavController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.12.2022
 */
val onBoardingModule = module {
    viewModel { OnBoardingViewModel() }
    factory { (navController: NavController) -> OnBoardingNavigationActions(navController) }
    factory { OnBoardingScreen() }
}