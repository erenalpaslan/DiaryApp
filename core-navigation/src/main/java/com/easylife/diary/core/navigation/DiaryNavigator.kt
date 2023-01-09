package com.easylife.diary.core.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onSubscription
import javax.inject.Inject

/**
 * Created by erenalpaslan on 4.01.2023
 */
abstract class Navigator {
    val gson = Gson()
    val navigationCommands =
        MutableSharedFlow<NavigationCommand>(extraBufferCapacity = Int.MAX_VALUE)

    // We use a StateFlow here to allow ViewModels to start observing navigation results before the initial composition,
    // and still get the navigation result later
    val navControllerFlow = MutableStateFlow<NavController?>(null)
}

abstract class DiaryNavigator : Navigator() {
    abstract fun navigate(route: String, optionsBuilder: (NavOptionsBuilder.() -> Unit)? = null)
    abstract fun <T> navigateBackWithResult(key: String, result: T, route: String? = null)
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
            is NavigationCommand.NavigateUpWithResult<*> -> {
                navUpWithResult(navigationCommand)
            }
        }
    }

    private fun NavController.navUpWithResult(
        navigationCommand: NavigationCommand.NavigateUpWithResult<*>
    ) {
        val backStackEntry =
            navigationCommand.route?.let { getBackStackEntry(it) }
                ?: previousBackStackEntry
        backStackEntry?.savedStateHandle?.set(
            navigationCommand.key,
            navigationCommand.result
        )

        navigationCommand.route?.let {
            popBackStack(it, false)
        } ?: run {
            popBackStack()
        }
    }

    fun <T> resultFlow(key: String): Flow<T> {
        val currentBackStackEntry = requireNotNull(navController()?.currentBackStackEntry)
        val savedStateHandle = currentBackStackEntry.savedStateHandle
        return savedStateHandle.getLiveData<T>(key).asFlow().onCompletion {
            savedStateHandle.remove<T>(key)
        }
    }
    suspend fun <T> observeOnce(key: String, observe: (T) -> Unit) {
        this.navController()?.currentBackStackEntry
            ?.savedStateHandle?.apply {
                val stateFlow = this.getStateFlow<T?>(key, null)
                stateFlow.collect {
                    if (it != null) {
                        observe(it)
                        this.remove<T>(key)
                    }
                }

            }
    }

    fun toJson(any: Any?): String? {
        return gson.toJson(any)
    }

    fun navController() = navControllerFlow.value
}