package com.easylife.diary.feature.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.feature.theme.util.DiaryTheme
import com.easylife.diary.feature.theme.component.ThemeItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

/**
 * Created by erenalpaslan on 19.12.2022
 */
class ThemeScreen() : BaseScreen<ThemeViewModel>() {
    @Composable
    override fun Screen() {
        val themeUiState by viewModel.uiState.collectAsStateWithLifecycle()
        ThemeContent(themeUiState = themeUiState)
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun ThemeContent(
        themeUiState: ThemeUiState,
    ) {
        val pagerState = rememberPagerState()
        var currentDiaryTheme by remember {
            mutableStateOf<DiaryTheme?>(null)
        }
        when (themeUiState) {
            ThemeUiState.Error -> {
                navigator.popBackStack()
            }
            ThemeUiState.Loading -> Unit
            is ThemeUiState.Success -> {
                Scaffold(
                    containerColor = currentDiaryTheme?.parentBackgroundColor
                        ?: MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        val (titleRef, themePagerRef, applyButtonRef) = createRefs()
                        Text(
                            text = stringResource(id = R.string.theme_selection_title),
                            modifier = Modifier.constrainAs(titleRef) {
                                top.linkTo(parent.top, 16.dp)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                width = Dimension.fillToConstraints
                            },
                            style = MaterialTheme.typography.headlineSmall,
                            color = currentDiaryTheme?.colorScheme?.onPrimary
                                ?: MaterialTheme.colorScheme.onPrimary
                        )
                        HorizontalPager(count = themeUiState.diaryThemes.size,
                            state = pagerState,
                            key = { page -> page },
                            itemSpacing = 16.dp,
                            contentPadding = PaddingValues(vertical = 54.dp, horizontal = 54.dp),
                            modifier = Modifier.constrainAs(themePagerRef) {
                                top.linkTo(titleRef.bottom, 32.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(applyButtonRef.top, 32.dp)
                                height = Dimension.fillToConstraints
                            }
                        ) { page ->
                            ThemeItem(
                                diaryTheme = themeUiState.diaryThemes[page], page = page
                            )
                            currentDiaryTheme = themeUiState.diaryThemes[pagerState.currentPage]
                        }
                        Button(modifier = Modifier
                            .constrainAs(applyButtonRef) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                width = Dimension.fillToConstraints
                            }, onClick = {
                            viewModel.onApplyClicked(currentDiaryTheme)
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = currentDiaryTheme?.colorScheme?.primary
                                    ?: MaterialTheme.colorScheme.primary,
                                contentColor = currentDiaryTheme?.colorScheme?.onPrimary
                                    ?: MaterialTheme.colorScheme.onPrimary
                            )
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_apply)
                            )
                        }
                    }
                }
            }

            ThemeUiState.ThemeApplied -> {
                navigator.popBackStack()
            }
        }

    }
}