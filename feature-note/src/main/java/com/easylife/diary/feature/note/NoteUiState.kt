package com.easylife.diary.feature.note

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.feature.note.enums.MoodTypes

/**
 * Created by erenalpaslan on 8.01.2023
 */
data class NoteUiState(
    var doneVisible: Boolean = false,
    var title: String? = null,
    var description: String? = null,
    var date: String = "",
    var mood: MoodTypes? = null,
    var isEditing: Boolean = false
) {
    fun isChanged(): Boolean {
        return !title.isNullOrEmpty() || !description.isNullOrEmpty() || mood != null
    }
}
