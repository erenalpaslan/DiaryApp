package com.easylife.diary.ui.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.base.BaseScreen
import com.easylife.diary.ui.theme.red

/**
 * Created by erenalpaslan on 19.12.2022
 */
class OnBoardingScreen: BaseScreen<OnBoardingViewModel, OnBoardingNavigationActions>() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold() {
            Column(modifier = Modifier
                .background(red)
                .fillMaxSize()) {

            }
        }
    }
}