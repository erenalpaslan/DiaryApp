package com.easylife.diary.feature.insight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 1.01.2023
 */
class InsightsScreen: BaseScreen<InsightsViewModel>() {
    @Composable
    override fun Screen() {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text("Insights")
                })
            }
        ) {
            Column(modifier = Modifier.padding(it)) {
                Text(text = "Insights screen")
            }
        }
    }
}