package com.easylife.diary.feature.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.calendar.CalendarPager
import com.easylife.diary.core.designsystem.components.calendar.CalendarState
import com.easylife.diary.core.designsystem.components.entry.EmptyEntryList
import com.easylife.diary.core.designsystem.components.entry.EntryList
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.navigation.screen.DiaryArgs
import com.easylife.diary.feature.calendar.components.CurrentDateButton
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by erenalpaslan on 1.01.2023
 */
class CalendarScreen : BaseScreen<CalendarViewModel>() {
    @Composable
    override fun Screen() {
        LaunchedEffect(viewModel) {
            navigator.resultFlow<Boolean>(DiaryArgs.ENTRY_AFFECTED).onEach {
                if (it) {
                    viewModel.selectedDate?.let {localDate ->
                        viewModel.onSelectionChanged(localDate)
                    }
                }
            }.launchIn(this)
        }

        Content()
    }

    @Composable
    private fun Content() {
        var showDateSelectionDialog by remember {
            mutableStateOf(false)
        }
        var isCurrentMonth by remember {
            mutableStateOf(true)
        }
        var calendarState = remember {
            mutableStateOf(CalendarState())
        }

        LaunchedEffect(key1 = calendarState.value.selected) {
            calendarState.value.selected?.let {
                viewModel.onSelectionChanged(it.date)
            }
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    navigationIcon = {
                        TextButton(onClick = {
                            showDateSelectionDialog = true
                        }) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(text = "January")
                                Icon(
                                    imageVector = Icons.Rounded.ExpandMore,
                                    contentDescription = "Expand more icon"
                                )
                            }
                        }
                    },
                    title = {

                    },
                    actions = {
                        CurrentDateButton(
                            isCurrentMonth = isCurrentMonth
                        ) {

                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier.padding(top = it.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CalendarPager(
                    calendarState = calendarState
                ) { point ->
                }
                Divider()
                if (calendarState.value.selected?.hasEntry == true) {
                    Spacer(modifier = Modifier.height(16.dp))
                    EntryScreen()
                }else {
                    EmptyEntryList(
                        message = "Record your thoughts and moods on this day"
                    )
                }
            }
        }
    }

    @Composable
    fun EntryScreen() {
        val list by viewModel.list.collectAsStateWithLifecycle()

        EntryList(list = list, onItemClicked = {
            viewModel.navigateWithEntry(it)
        })
    }
}