package com.easylife.diary.feature.note

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.common.util.DateUtil.formattedDate
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.AddEntryUseCase
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.feature.note.enums.MoodTypes
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 2.01.2023
 */
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val navigator: DiaryNavigator,
    private val addEntryUseCase: AddEntryUseCase,
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<NoteUiState> = MutableStateFlow(NoteUiState())
    val uiState = _uiState.asStateFlow().onEach {
        it.doneVisible = it.isChanged()
    }

    init {
        viewModelScope.launch {
            val diaryNote = savedStateHandle.get<DiaryNote?>(DiaryArgs.NOTE_KEY)

            _uiState.update {
                it.copy(
                    title = diaryNote?.title ?: "",
                    description = diaryNote?.description ?: "",
                    date = diaryNote?.date?.formattedDate() ?: DateUtil.getCurrentDate(),
                    mood = MoodTypes.from(diaryNote?.moodId ?: -1)
                )
            }
        }
    }

    fun onDoneClicked() {
        viewModelScope.launch {
            showProgress()
            addEntryUseCase.execute(AddEntryUseCase.Params(
                title = _uiState.value.title,
                description = _uiState.value.description,
                moodId = _uiState.value.mood?.id
            )).collect()
            navigator.navigateBackWithResult(
                key = DiaryArgs.ENTRY_AFFECTED,
                result = true
            )
            hideProgress()
        }
    }

    fun onMoodSelected(mood: MoodTypes) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    mood = mood,
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