package com.easylife.diary.feature.diary

/**
 * Created by erenalpaslan on 1.01.2023
 */
sealed interface DiaryUiState {

    object Loading : DiaryUiState

    object EmptyDiary: DiaryUiState

    data class DataLoaded(
        val data: List<String> = emptyList(),
        val currentDate: String? = null
    ): DiaryUiState
}
