package com.easylife.diary.feature.splash

/**
 * Created by erenalpaslan on 19.12.2022
 */
sealed interface SplashUiState {

    object Loading: SplashUiState

    /**
     * User applied or skipped the theme selection phases
     */
    object OnBoardedUser: SplashUiState

    /**
     * User need to be directed towards to the theme selection
     */
    object NewComer: SplashUiState
}