package com.easylife.diary.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.R
import com.easylife.diary.base.BaseScreen

/**
 * Created by erenalpaslan on 19.12.2022
 */
class SplashScreen : BaseScreen<SplashViewModel, SplashNavigationActions>() {
    @OptIn(ExperimentalLifecycleComposeApi::class)
    @Composable
    override fun Content() {
        val splashUiState by viewModel.uiState.collectAsStateWithLifecycle()
        when(splashUiState) {
            SplashUiState.Loading -> {}
            SplashUiState.NewComer -> navigationActions.splashToOnBoarding()
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