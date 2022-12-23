package com.easylife.diary.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 19.12.2022
 */
class OnBoardingScreen(
    navigateToMain: () -> Unit
) : BaseScreen<OnBoardingViewModel>() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold() {
            Column(
                modifier = Modifier
                    .padding(it)
                    .background(red)
                    .fillMaxSize()
            ) {

            }
        }
    }
}