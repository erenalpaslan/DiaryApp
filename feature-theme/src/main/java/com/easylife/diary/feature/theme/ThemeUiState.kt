package com.easylife.diary.feature.theme

import com.easylife.diary.feature.theme.util.DiaryTheme

/**
 * Created by erenalpaslan on 24.12.2022
 */
sealed interface ThemeUiState {

    object Loading : ThemeUiState

    data class Success(
        /**
         * Gathered themes from pre-defined in room.db
         */
        val diaryThemes: List<DiaryTheme>
    ): ThemeUiState

    object Error: ThemeUiState

    object ThemeApplied: ThemeUiState
}
