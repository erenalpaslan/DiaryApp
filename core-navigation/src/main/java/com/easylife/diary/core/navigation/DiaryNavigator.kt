package com.easylife.diary.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onSubscription

/**
 * Created by erenalpaslan on 4.01.2023
 */
abstract class Navigator {
    val navigationCommands = MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

    // We use a StateFlow here to allow ViewModels to start observing navigation results before the initial composition,
    // and still get the navigation result later
    val navControllerFlow = MutableStateFlow<NavController?>(null)
}

abstract class DiaryNavigator : Navigator() {
    abstract fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null)
    abstract fun popUpTo(route: String, where: String, inclusive: Boolean)
    abstract fun popBackStack()

    suspend fun handleNavigationCommands(navController: NavController) {
        navigationCommands
            .onSubscription { this@DiaryNavigator.navControllerFlow.value = navController }
            .onCompletion { this@DiaryNavigator.navControllerFlow.value = null }
            .collect {
                navController.handleComposeNavigationCommand(it)
            }
    }

    private fun NavController.handleComposeNavigationCommand(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.NavigateToRoute -> {
                navigate(navigationCommand.route, navigationCommand.navOptions)
            }
            is NavigationCommand.PopUpToRoute -> {
                navigate(navigationCommand.route) {
                    popUpTo(navigationCommand.where) {
                        inclusive = navigationCommand.inclusive
                    }
                }
            }
            NavigationCommand.PopBackStack -> popBackStack()
        }
    }

    fun navController() = navControllerFlow.value
}