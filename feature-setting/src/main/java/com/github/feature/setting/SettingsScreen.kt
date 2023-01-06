package com.github.feature.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.navigation.screen.DiaryRoutes

/**
 * Created by erenalpaslan on 1.01.2023
 */
class SettingsScreen: BaseScreen<SettingsViewModel>() {
    @Composable
    override fun Screen() {
        Scaffold() {
            Column(modifier = Modifier.padding(it)) {
                Button(onClick = {
                    viewModel.onThemeButtonClicked()
                }) {
                    Text(text = "Themes")
                }
            }
        }
    }
}