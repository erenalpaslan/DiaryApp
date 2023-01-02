package com.easylife.diary.feature.diary

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
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
class DiaryViewModel @Inject constructor(): BaseViewModel() {

    private val _uiState: MutableStateFlow<DiaryUiState> = MutableStateFlow(DiaryUiState())
    val uiSate: StateFlow<DiaryUiState> = _uiState.asStateFlow()

    fun onSearchClicked() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(searching = true)
            }
        }
    }

    fun onClearSearchClicked() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(searching = false)
            }
        }
    }

}