package com.easylife.diary.core.navigation

import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import javax.inject.Inject

/**
 * Created by erenalpaslan on 4.01.2023
 */
class DiaryComposeNavigator @Inject constructor(): DiaryNavigator() {
    override fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)?) {
        val options = optionsBuilder?.let { navOptions(it) }
        navigationCommands.tryEmit(NavigationCommand.NavigateToRoute(route, options))
    }

    override fun popUpTo(route: String, where: String, inclusive: Boolean) {
        navigationCommands.tryEmit(NavigationCommand.PopUpToRoute(route, where, inclusive))
    }

    override fun popBackStack() {
        navigationCommands.tryEmit(NavigationCommand.PopBackStack)
    }

    override fun <T> navigateBackWithResult(
        key: String,
        result: T,
        route: String?
    ) {
        navigationCommands.tryEmit(
            NavigationCommand.NavigateUpWithResult(
                key = key,
                result = result,
                route = route
            )
        )
    }
}