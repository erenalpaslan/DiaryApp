package com.easylife.diary.ui.screen.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import com.easylife.diary.core.navigation.screen.DiaryRoutes.noteRoute
import com.easylife.diary.core.navigation.screen.DiaryRoutes.themeRoute
import com.easylife.diary.feature.main.navigation.BottomNavigationItem
import com.easylife.diary.ui.navigation.BottomNavScreen
import com.easylife.diary.ui.navigation.DiaryNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Created by erenalpaslan on 5.01.2023
 */
@Composable
fun MainDiary(
    navController: NavHostController,
    navigator: DiaryNavigator
) {
    var currentRoute by remember {
        mutableStateOf(DiaryRoutes.diaryRoute)
    }

    val navigateToBottomTabs: (String) -> Unit = {
        navController.navigate(it) {
            popUpTo(currentRoute) {
                inclusive = true
            }
        }
    }

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            if (currentDestination?.route in bottomNavVisible) {
                BottomAppBar(
                    actions = {
                        BottomNavScreen.getScreens().forEach { bottomNavScreen ->
                            BottomNavigationItem(
                                selected =  currentDestination?.hierarchy?.any { it.route == bottomNavScreen.route } == true,
                                onClick = {
                                    navigateToBottomTabs(bottomNavScreen.route)
                                    currentRoute = bottomNavScreen.route
                                },
                                icon = bottomNavScreen.icon,
                                label = bottomNavScreen.label,
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                navigator.navigate(noteRoute)
                            },
                            containerColor = MaterialTheme.colorScheme.primary,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                        ) {
                            Icon(Icons.Filled.Add, "Fab")
                        }
                    },
                    contentPadding = PaddingValues(start = 11.dp)
                )
            }
        }
    ) {
        DiaryNavHost(
            navigator = navigator,
            navController = navController,
            paddingValues = it
        )
    }
}

private val bottomNavVisible = listOf(
    DiaryRoutes.diaryRoute,
    DiaryRoutes.calendarRoute,
    DiaryRoutes.insightsRoute,
    DiaryRoutes.settingsRoute
)