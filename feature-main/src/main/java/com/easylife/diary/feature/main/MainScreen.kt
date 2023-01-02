package com.easylife.diary.feature.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.feature.diary.navigation.diaryRoute
import com.easylife.diary.feature.main.navigation.BottomNavGraph
import com.easylife.diary.feature.main.navigation.BottomNavScreen
import com.easylife.diary.feature.main.navigation.BottomNavigationItem
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * Created by erenalpaslan on 27.12.2022
 */
class MainScreen(
    val navigateToTheme: () -> Unit,
    val navigateToNote: () -> Unit
) : BaseScreen<MainViewModel>() {
    @Composable
    override fun Screen() {
        Content()
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun Content() {
        val bottomNavController = rememberAnimatedNavController()
        var currentRoute by remember {
            mutableStateOf(diaryRoute)
        }

        val navigateTo: (String) -> Unit = {
            bottomNavController.navigate(it) {
                popUpTo(currentRoute) {
                    inclusive = true
                }
            }
        }

        Scaffold(
            bottomBar = {
                BottomAppBar(
                    actions = {
                        BottomNavScreen.getScreens().forEach { bottomNavScreen ->
                            BottomNavigationItem(
                                selected = bottomNavScreen.route == currentRoute,
                                onClick = {
                                    navigateTo(bottomNavScreen.route)
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
                                navigateToNote()
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
        ) {
            BottomNavGraph(
                navController = bottomNavController,
                paddingValues = it,
                navigateToTheme = {
                    navigateToTheme()
                }
            )
        }
    }
}