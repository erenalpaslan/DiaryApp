package com.github.feature.setting

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.navigation.screen.DiaryRoutes

/**
 * Created by erenalpaslan on 1.01.2023
 */
class SettingsScreen: BaseScreen<SettingsViewModel>() {
    @Composable
    override fun Screen() {
        Button(onClick = {
            viewModel.onThemeButtonClicked()
        }) {
            Text(text = "Themes")
        }
    }
}