package com.easylife.diary.feature.theme

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.feature.theme.util.Themes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 19.12.2022
 */
class ThemeViewModel: BaseViewModel() {

    private val _uiState: MutableStateFlow<ThemeUiState> = MutableStateFlow(ThemeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                ThemeUiState.Success(
                    Themes.getThemes()
                )
            }
        }
    }

    fun onApplyClicked() {

    }

}