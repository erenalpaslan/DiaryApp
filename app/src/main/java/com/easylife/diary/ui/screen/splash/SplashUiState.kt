package com.easylife.diary.ui.screen.splash

/**
 * Created by erenalpaslan on 19.12.2022
 */
sealed interface SplashUiState {

    object Loading: SplashUiState

    /**
     * User visited onboard previously or skipped onboarding phases
     */
    object OnBoardedUser: SplashUiState

    /**
     * There is a onboarding state
     */
    object NewComer: SplashUiState
}