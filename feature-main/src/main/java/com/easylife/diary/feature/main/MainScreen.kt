package com.easylife.diary.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 27.12.2022
 */
class MainScreen(
    val navigateToTheme: () -> Unit
): BaseScreen<MainViewModel>() {
    @Composable
    override fun Content() {
        Scaffold() {
            Column(modifier = Modifier.padding(it)) {
                Button(onClick = { navigateToTheme() }) {
                    Text(text = "To Theme")
                }
            }
        }
    }
}