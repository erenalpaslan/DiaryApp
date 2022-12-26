package com.easylife.diary.feature.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.easylife.diary.feature.theme.util.Theme
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
        var currentTheme by remember {
            mutableStateOf<Theme?>(null)
        }
        when (themeUiState) {
            ThemeUiState.Error -> navigateToMain()
            ThemeUiState.Loading -> Unit
            is ThemeUiState.Success -> {
                Scaffold(
                    containerColor = currentTheme?.parentBackgroundColor
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
                            color = currentTheme?.colorScheme?.onPrimary
                                ?: MaterialTheme.colorScheme.onPrimary
                        )
                        HorizontalPager(count = themeUiState.themes.size,
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
                                theme = themeUiState.themes[page], page = page
                            )
                            currentTheme = themeUiState.themes[pagerState.currentPage]
                        }
                        Button(modifier = Modifier
                            .constrainAs(applyButtonRef) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start, 16.dp)
                                end.linkTo(parent.end, 16.dp)
                                width = Dimension.fillToConstraints
                            }, onClick = {
                            viewModel.onApplyClicked()
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = currentTheme?.colorScheme?.primary
                                    ?: MaterialTheme.colorScheme.primary,
                                contentColor = currentTheme?.colorScheme?.onPrimary
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
                navigateToMain()
            }
        }

    }
}