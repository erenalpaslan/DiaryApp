package com.easylife.diary.feature.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 1.01.2023
 */
class DiaryScreen: BaseScreen<DiaryViewModel>() {
    
    @Composable
    override fun Screen() {
        val uiState by viewModel.uiSate.collectAsStateWithLifecycle()

        Content(uiState = uiState)
    }

    @Composable
    fun Content(uiState: DiaryUiState) {
        Scaffold(
            topBar = {
                if (uiState.searching) {
                    androidx.compose.material.TopAppBar(
                        title = {
                            Text(text = "Search")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                viewModel.onClearSearchClicked()
                            }) {
                                Icon(
                                    imageVector = Icons.Rounded.ArrowBackIosNew,
                                    contentDescription = "Back Arrow"
                                )
                            }
                        },
                        backgroundColor = MaterialTheme.colorScheme.background
                    )
                } else {
                    androidx.compose.material.TopAppBar(
                        title = {
                            Text(text = "Diary")
                        },
                        actions = {
                            IconButton(onClick = {
                                viewModel.onSearchClicked()
                            }) {
                                Icon(
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = "Search Icon"
                                )
                            }
                        },
                        backgroundColor = MaterialTheme.colorScheme.background
                    )
                }
            }
        ) {
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize()
            ) {
                Button(onClick = { }) {
                    Text(text = "To Theme")
                }
            }
        }
    }
    
}