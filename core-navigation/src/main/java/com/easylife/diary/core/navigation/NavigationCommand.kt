package com.easylife.diary.core.navigation

import androidx.navigation.NavOptions

/**
 * Created by erenalpaslan on 4.01.2023
 */
sealed class NavigationCommand {

    object PopBackStack: NavigationCommand()

    data class NavigateToRoute(
        val route: String,
        val navOptions: NavOptions? = null
    ): NavigationCommand()

    data class PopUpToRoute(
        val route: String,
        val where: String,
        val inclusive: Boolean
    ): NavigationCommand()
}
