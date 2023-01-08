package com.easylife.diary.feature.note

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.navigation.DiaryNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    val uiState = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            val diaryNote = navigator.navController()?.currentBackStackEntry?.arguments?.getParcelable<DiaryNote>(
                NoteScreen.NOTE_KEY
            )

            _uiState.update {
                it.copy(
                    title = mutableStateOf(diaryNote?.title ?: ""),
                    description = mutableStateOf(diaryNote?.description ?: ""),
                    date = diaryNote?.date?.toString(),
                    moodIcon = diaryNote?.moodId ?: -1
                )
            }
        }
    }

    fun onDoneClicked() {
        viewModelScope.launch {

        }
    }

}