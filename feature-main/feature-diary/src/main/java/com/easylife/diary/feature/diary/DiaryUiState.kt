package com.easylife.diary.feature.diary

/**
 * Created by erenalpaslan on 1.01.2023
 */
data class DiaryUiState(
    val datas: List<String> = emptyList(),
    val searching: Boolean = false
)
