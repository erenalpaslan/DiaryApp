package com.easylife.diary.feature.note

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 8.01.2023
 */
data class NoteUiState(
    val doneVisible: Boolean = false,
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf(""),
    val date: String? = "",
    val moodIcon: Int = -1
)
