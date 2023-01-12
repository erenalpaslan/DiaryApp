package com.easylife.diary.feature.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.CalendarPager
import com.easylife.diary.core.designsystem.theme.red
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
                            viewModel.onCurrentDateSelected()
                        }
                    }
                )
            }
        ) {
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize()) {
                CalendarPager()
            }
        }

        if (showDateSelectionDialog) {

        }
    }
}