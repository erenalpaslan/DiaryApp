package com.easylife.diary.feature.diary

import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 1.01.2023
 */
sealed interface DiaryUiState {

    object Loading : DiaryUiState

    object EmptyDiary: DiaryUiState

    data class DataLoaded(
        val data: List<DiaryNote> = emptyList(),
        val currentDate: String? = null
    ): DiaryUiState
}
