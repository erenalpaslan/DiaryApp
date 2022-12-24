package com.easylife.diary.feature.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.feature.onboarding.component.ThemeItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

/**
 * Created by erenalpaslan on 19.12.2022
 */
class ThemeScreen(
    val navigateToMain: () -> Unit
) : BaseScreen<ThemeViewModel>() {
    @Composable
    override fun Content() {
        val themeUiState by viewModel.uiState.collectAsStateWithLifecycle()
        ThemeContent(themeUiState = themeUiState)
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun ThemeContent(
        themeUiState: ThemeUiState,
    ) {
        val pagerState = rememberPagerState()

        Scaffold() {
            when(themeUiState) {
                ThemeUiState.Error -> navigateToMain()
                ThemeUiState.Loading -> Unit
                is ThemeUiState.Success -> {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        HorizontalPager(
                            count = themeUiState.themes.size,
                            state = pagerState,
                            key = { page -> page },
                            itemSpacing = 16.dp,
                            contentPadding = PaddingValues(vertical = 54.dp, horizontal = 54.dp)
                        ) {page ->
                            ThemeItem(
                                theme = themeUiState.themes[page],
                                page = page
                            )
                        }
                    }
                }
            }
        }
    }
}