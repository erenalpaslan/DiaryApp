package com.easylife.diary.ui.screen.main

import androidx.lifecycle.LiveData
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.feature.theme.util.DiaryTheme
import com.easylife.diary.feature.theme.util.DiaryThemeObservable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by erenalpaslan on 26.12.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val diaryThemeObservable: DiaryThemeObservable
): BaseViewModel() {

    val theme: LiveData<DiaryTheme> = diaryThemeObservable

}