package com.easylife.diary.feature.onboarding

import com.easylife.diary.core.model.theme.Theme

/**
 * Created by erenalpaslan on 24.12.2022
 */
sealed interface ThemeUiState {

    object Loading : ThemeUiState

    data class Success(
        /**
         * Gathered themes from pre-defined in room.db
         */
        val themes: List<Theme>
    ): ThemeUiState

    object Error: ThemeUiState
}
