package com.easylife.diary.feature.diary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.entry.EmptyEntryList
import com.easylife.diary.core.designsystem.components.entry.EntryList
import com.easylife.diary.core.navigation.screen.DiaryArgs
import com.easylife.diary.feature.diary.components.DiaryScreenTopBar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by erenalpaslan on 1.01.2023
 */
class DiaryScreen : BaseScreen<DiaryViewModel>() {

    @Composable
    override fun Screen() {
        val uiState by viewModel.uiSate.collectAsStateWithLifecycle()

        LaunchedEffect(viewModel) {
            navigator.resultFlow<Boolean>(DiaryArgs.ENTRY_AFFECTED).onEach {
                if (it) {
                    viewModel.getAllEntries()
                }
            }.launchIn(this)
        }

        Content(uiState = uiState)
    }

    @Composable
    fun Content(uiState: DiaryUiState) {
        Scaffold(
            topBar = {
                DiaryScreenTopBar(
                    isEmpty = uiState is DiaryUiState.EmptyDiary,
                    onSearched = {text ->
                        viewModel.onSearch(text)
                    },
                    onCleared = {
                        viewModel.onSearch(null)
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
            ) {
                when (uiState) {
                    DiaryUiState.Loading -> {}
                    DiaryUiState.EmptyDiary -> {
                        EmptyEntryList(
                            message = "Write down your thoughts and track your mood to get insights. Add your first entry"
                        )
                    }
                    is DiaryUiState.DataLoaded -> {
                        EntryList(list = uiState.data, onItemClicked = {entry ->
                            viewModel.navigateWithEntry(entry)
                        })
                    }
                }
            }
        }
    }


}