package com.easylife.diary.feature.main

/**
 * Created by erenalpaslan on 1.01.2023
 */
data class MainUiState(
    val datas: List<String> = emptyList(),
    val searching: Boolean = false
)