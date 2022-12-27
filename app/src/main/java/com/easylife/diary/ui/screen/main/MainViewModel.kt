package com.easylife.diary.ui.screen.main

import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.feature.theme.util.ThemeObservable
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by erenalpaslan on 26.12.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    val themeObservable: ThemeObservable
): BaseViewModel() {
}