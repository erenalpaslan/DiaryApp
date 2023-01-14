package com.easylife.diary.core.designsystem.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.designsystem.theme.black
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.designsystem.theme.green
import com.easylife.diary.core.model.calendar.DatePoint
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

/**
 * Created by erenalpaslan on 12.01.2023
 */
@Composable
fun CalendarPager(onSelectionChanged: (DatePoint) -> Unit) {
    val viewModel: CalendarViewModel = hiltViewModel()
    val state by viewModel.calendarState.collectAsStateWithLifecycle()

    CalendarContent(
        state = state,
        onPageChanged = {
            viewModel.onPageChanged(it)
        },
        onSelectionChanged = {
                point, _ ->
            viewModel.onSelectionChanged(point)
            onSelectionChanged(point)
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CalendarContent(
    state: CalendarState,
    onSelectionChanged: (DatePoint, Int) -> Unit,
    onPageChanged: (Int) -> Unit
) {
    val dayNames = remember {
        mutableStateOf(DateUtil.getDayNameList())
    }
    val pagerState = rememberPagerState(state.page)

    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            dayNames.value.forEach {
                Text(
                    text = it, style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .defaultMinSize(minWidth = 20.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            if (state.currentDatePoints.isNotEmpty()) {
                val points = listOf(state.previousDatePoints, state.currentDatePoints, state.nextDatePoints)
                HorizontalPager(
                    count = points.size,
                    state = pagerState
                ) {page ->
                    Column(modifier = Modifier.fillMaxWidth()) {
                        (0..5).forEach { rowCount ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                (0..6).forEach { columnCount ->
                                    val pos = ((rowCount * 7) + (columnCount + 1))
                                    val point = points[page][pos]
                                    DatePointItem(
                                        selected = state.selected == point,
                                        point = point,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f)
                                    ) {
                                        onSelectionChanged(it, pos)
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                        }
                    }
                }
            }
        }
    }
}