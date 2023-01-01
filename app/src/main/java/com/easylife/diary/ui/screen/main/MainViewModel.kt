package com.easylife.diary.ui.screen.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.preferences.PreferencesKeys
import com.easylife.diary.core.preferences.PreferencesManager
import com.easylife.diary.feature.theme.util.DiaryTheme
import com.easylife.diary.feature.theme.util.DiaryThemeObservable
import com.easylife.diary.feature.theme.util.Themes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 26.12.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val diaryThemeObservable: DiaryThemeObservable,
    private val preferencesManager: PreferencesManager
): BaseViewModel() {

    val theme: LiveData<DiaryTheme> = diaryThemeObservable

    init {
        viewModelScope.launch {
            val selectedThemeId = preferencesManager.getInt(PreferencesKeys.SELECTED_THEME_ID, 1)
            val selectedTheme = Themes.from(selectedThemeId)
            diaryThemeObservable.postValue(selectedTheme)
        }
    }

}