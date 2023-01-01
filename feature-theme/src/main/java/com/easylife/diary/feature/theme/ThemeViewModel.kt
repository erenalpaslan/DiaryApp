package com.easylife.diary.feature.theme

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.preferences.PreferencesKeys
import com.easylife.diary.core.preferences.PreferencesManager
import com.easylife.diary.feature.theme.util.DiaryTheme
import com.easylife.diary.feature.theme.util.DiaryThemeObservable
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
    private val diaryThemeObservable: DiaryThemeObservable,
    private val preferencesManager: PreferencesManager
) : BaseViewModel() {

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

    fun onApplyClicked(diaryTheme: DiaryTheme?) {
        viewModelScope.launch {
            diaryThemeObservable.postValue(diaryTheme)
            preferencesManager.setInt(PreferencesKeys.SELECTED_THEME_ID, diaryTheme?.id ?: 1)
            preferencesManager.setBoolean(PreferencesKeys.IS_FIRST_ENTER, false)
            _uiState.update {
                ThemeUiState.ThemeApplied
            }
        }
    }

}