package com.easylife.diary.ui.screen.splash

import androidx.navigation.NavController
import com.easylife.diary.base.BaseActions
import com.easylife.diary.ui.navigation.Screen

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashNavigationActions(
    navController: NavController
): BaseActions() {

    val splashToOnBoarding: () -> Unit = {
        navController.navigate(Screen.OnBoarding.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    val splashToMain: () -> Unit = {
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}