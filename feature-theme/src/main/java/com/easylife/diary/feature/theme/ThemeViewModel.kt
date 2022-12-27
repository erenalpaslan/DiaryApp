package com.easylife.diary.feature.theme

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.feature.theme.util.Theme
import com.easylife.diary.feature.theme.util.ThemeObservable
import com.easylife.diary.feature.theme.util.Themes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 19.12.2022
 */
@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeObservable: ThemeObservable
): BaseViewModel() {

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

    fun onApplyClicked(theme: Theme?) {
        viewModelScope.launch {
            themeObservable.postValue(theme)
        }
    }

}