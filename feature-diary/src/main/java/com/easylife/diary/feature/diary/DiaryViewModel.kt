package com.easylife.diary.feature.diary

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.GetAllEntriesUseCase
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryArgs
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class DiaryViewModel @Inject constructor(
    private val navigator: DiaryNavigator,
    private val getAllEntriesUseCase: GetAllEntriesUseCase
): BaseViewModel() {

    private val _uiState: MutableStateFlow<DiaryUiState> = MutableStateFlow(DiaryUiState.Loading)
    val uiSate: StateFlow<DiaryUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllEntries()
        }
    }

    fun getAllEntries() {
        viewModelScope.launch {
            getAllEntriesUseCase.execute(Unit).collect {result ->
                when(result) {
                    is DiaryResult.Error -> _error.postValue(result.message)
                    is DiaryResult.Success -> _uiState.update {
                        if (result.data.isNullOrEmpty()) {
                            DiaryUiState.EmptyDiary
                        }else {
                            DiaryUiState.DataLoaded(
                                data = result.data ?: emptyList()
                            )
                        }
                    }
                }
            }
        }
    }

    fun navigateWithEntry(entry: DiaryNote) {
        navigator.navigate(
            route = "${DiaryRoutes.noteRoute}?${DiaryArgs.NOTE_KEY}=${navigator.toJson(entry)}"
        )
    }

}