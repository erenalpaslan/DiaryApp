package com.easylife.diary.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.easylife.diary.feature.main.navigation.mainScreen
import com.easylife.diary.feature.main.navigation.navigateToMain
import com.easylife.diary.feature.theme.navigation.navigateToTheme
import com.easylife.diary.feature.theme.navigation.themeScreen
import com.easylife.diary.feature.splash.navigation.splashRoute
import com.easylife.diary.feature.splash.navigation.splashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = splashRoute
    ) {
        splashScreen(
            navigateToTheme = {
                navController.navigateToTheme(
                    NavOptions.Builder()
                        .setPopUpTo(splashRoute, true)
                        .build()
                )
            },
            navigateToMain = {
                navController.navigateToMain()
            }
        )
        themeScreen(
            navigateToMain = {
                navController.navigateToMain()
            }
        )

        mainScreen()
        /*composable(route = Screen.Splash.route) {
            get<SplashScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.Home.route) {
            get<HomeScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(
            route = Screen.Search.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(700))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(700))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(700))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(700))
            }
        ) {
            get<SearchScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(
            route = "${Screen.Wallpaper.route}?${WallpaperScreen.WALLPAPER_KEY}={${WallpaperScreen.WALLPAPER_KEY}}",
            arguments = listOf(navArgument(WallpaperScreen.WALLPAPER_KEY) {
                type = WallpaperNavType()
            }),
        ) {
            get<WallpaperScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.About.route) {
            get<AboutScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.Collection.route) {
            get<CollectionScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }*/

        /* composable(route = Screen.OnBoarding.route) {
             get<OnBoardingScreen>().Create(
                 viewModel = getViewModel(),
                 navController = navController,
                 navigationActions = get { parametersOf(navController) }
             )
         }



         composable(
             route = Screen.Theme.route,
             enterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             exitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             popEnterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             },
             popExitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             }
         ) {
             get<ThemeSelectionScreen>().Create(
                 viewModel = getViewModel(),
                 navController = navController,
                 navigationActions = get { parametersOf(navController) }
             )
         }

         composable(
             route = Screen.Setting.route,
             enterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             exitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             popEnterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             },
             popExitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             }
         ) {
             get<SettingScreen>().Create(
                 viewModel = getViewModel(),
                 navController = navController,
                 navigationActions = get { parametersOf(navController) }
             )
         }

         composable(
             route = Screen.Paywall.route,
             enterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             exitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             popEnterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             },
             popExitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             }
         ) {
             get<PaywallScreen>().Create(
                 viewModel = getViewModel(),
                 navController = navController,
                 navigationActions = get { parametersOf(navController) }
             )
         }

         composable(
             route = Screen.Favorite.route,
             enterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             exitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Up, animationSpec = tween(700))
             },
             popEnterTransition = {
                 slideIntoContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             },
             popExitTransition = {
                 slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, animationSpec = tween(700))
             }
         ) {
             get<FavoriteScreen>().Create(
                 viewModel = getViewModel(),
                 navController = navController,
                 navigationActions = get { parametersOf(navController) }
             )
         }*/
    }
}