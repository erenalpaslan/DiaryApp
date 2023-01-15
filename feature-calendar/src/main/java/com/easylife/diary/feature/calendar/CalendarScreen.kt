package com.easylife.diary.feature.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.calendar.CalendarPager
import com.easylife.diary.core.designsystem.components.calendar.CalendarState
import com.easylife.diary.core.model.calendar.DatePoint
import com.easylife.diary.feature.calendar.components.CurrentDateButton

/**
 * Created by erenalpaslan on 1.01.2023
 */
class CalendarScreen : BaseScreen<CalendarViewModel>() {
    @Composable
    override fun Screen() {
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
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CalendarPager(
                    calendarState = calendarState
                ) {point ->
                    viewModel.onSelectionChanged(point)
                }
                Divider()
                Text(text = calendarState.value.currentSelectedDate.toString())
            }
        }

        if (showDateSelectionDialog) {

        }
    }
}