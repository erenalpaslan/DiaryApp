package com.easylife.diary.feature.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.feature.theme.R
import com.easylife.diary.feature.theme.component.ThemeItem
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

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.theme_selection_title))
                    }
                )
            }
        ) {
            when (themeUiState) {
                ThemeUiState.Error -> navigateToMain()
                ThemeUiState.Loading -> Unit
                is ThemeUiState.Success -> {
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        val (themePagerRef, applyButtonRef) = createRefs()

                        HorizontalPager(
                            count = themeUiState.themes.size,
                            state = pagerState,
                            key = { page -> page },
                            itemSpacing = 16.dp,
                            contentPadding = PaddingValues(vertical = 54.dp, horizontal = 54.dp),
                            modifier = Modifier.constrainAs(themePagerRef) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(applyButtonRef.top, 32.dp)
                            }
                        ) { page ->
                            ThemeItem(
                                theme = themeUiState.themes[page],
                                page = page
                            )
                        }
                        Button(
                            modifier = Modifier.constrainAs(applyButtonRef) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                width = Dimension.fillToConstraints
                            },
                            onClick = {
                                viewModel.onApplyClicked()
                            }
                        ) {
                            Text(text = stringResource(id = R.string.btn_apply))
                        }
                    }
                }

                ThemeUiState.ThemeApplied -> {
                    navigateToMain()
                }
            }
        }
    }
}