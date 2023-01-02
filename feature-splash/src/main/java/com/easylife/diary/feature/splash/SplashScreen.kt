package com.easylife.diary.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashScreen(
    val navigateToTheme: () -> Unit,
    val navigateToMain: () -> Unit
) : BaseScreen<SplashViewModel>() {
    @OptIn(ExperimentalLifecycleComposeApi::class)
    @Composable
    override fun Screen() {
        val splashUiState by viewModel.uiState.collectAsStateWithLifecycle()
        when(splashUiState) {
            SplashUiState.Loading -> {}
            SplashUiState.NewComer -> navigateToTheme()
            SplashUiState.OnBoardedUser -> navigateToMain()
        }
        SplashContent()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SplashContent() {
        Scaffold() {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dev_app_logo),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}