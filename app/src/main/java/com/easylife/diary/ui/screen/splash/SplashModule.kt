package com.easylife.diary.ui.navigation

import androidx.navigation.NavController
import com.easylife.diary.ui.screen.splash.SplashNavigationActions
import com.easylife.diary.ui.screen.splash.SplashScreen
import com.easylife.diary.ui.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.12.2022
 */
val splashModule = module {
    viewModel { SplashViewModel(get()) }
    factory { (navController: NavController) -> SplashNavigationActions(navController) }
    factory { SplashScreen() }
}