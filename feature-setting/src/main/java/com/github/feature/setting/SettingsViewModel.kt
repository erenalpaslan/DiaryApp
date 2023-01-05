package com.github.feature.setting

import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    val navigator: DiaryNavigator
): BaseViewModel() {

    fun onThemeButtonClicked() {
        navigator.navigate(DiaryRoutes.themeRoute)
    }

}