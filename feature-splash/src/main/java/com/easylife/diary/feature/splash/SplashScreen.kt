package com.easylife.diary.feature.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.easylife.diary.R
import com.easylife.diary.core.designsystem.base.BaseScreen

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashScreen(
    navigateToOnBoarding: () -> Unit,
    navigateToMain: () -> Unit
) : BaseScreen<SplashViewModel>() {
    @OptIn(ExperimentalLifecycleComposeApi::class)
    @Composable
    override fun Content() {
        val splashUiState by viewModel.uiState.collectAsStateWithLifecycle()
        when(splashUiState) {
            SplashUiState.Loading -> {}
            SplashUiState.NewComer -> navigateToOn
            SplashUiState.OnBoardedUser -> navigationActions.splashToMain()
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
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = ""
                )
            }
        }
    }
}