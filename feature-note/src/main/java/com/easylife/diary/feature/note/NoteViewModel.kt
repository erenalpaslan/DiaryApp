package com.easylife.diary.feature.note

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.enums.MoodTypes
import com.easylife.diary.core.navigation.DiaryNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 2.01.2023
 */
@HiltViewModel
class NoteViewModel @Inject constructor(
    navigator: DiaryNavigator
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<NoteUiState> = MutableStateFlow(NoteUiState())
    val uiState = _uiState.asStateFlow().onEach {
        it.doneVisible = it.isChanged()
    }

    init {
        viewModelScope.launch {
            val diaryNote = navigator.navController()?.currentBackStackEntry?.arguments?.getParcelable<DiaryNote>(
                NoteScreen.NOTE_KEY
            )

            _uiState.update {
                it.copy(
                    title = diaryNote?.title ?: "",
                    description = diaryNote?.description ?: "",
                    date = diaryNote?.date?.toString(),
                    moodIcon = diaryNote?.moodId ?: -1
                )
            }
        }
    }

    fun onDoneClicked() {
        viewModelScope.launch {
            //TODO: Save diary entry call here!
        }
    }

    fun onMoodSelected(mood: MoodTypes) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    moodIcon = mood.id,
                )
            }
        }
    }

    fun onTitleChanged(title: String?) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    title = title ?: ""
                )
            }
        }
    }

    fun onDescriptionChanged(description: String?) {
        viewModelScope.launch {
            _uiState.update {
               it.copy(
                   description = description ?: "",
               )
            }
        }
    }

}