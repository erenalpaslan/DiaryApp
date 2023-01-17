package com.easylife.diary.core.designsystem.components.calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.extension.isCurrentDate
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.domain.usecases.GetDatePointListByLocalDateUseCase
import com.easylife.diary.core.domain.usecases.GetDateUseCase
import com.easylife.diary.core.model.calendar.DatePoint
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

/**
 * Created by erenalpaslan on 14.01.2023
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getDateUseCase: GetDateUseCase,
    private val getDatePointListByLocalDateUseCase: GetDatePointListByLocalDateUseCase
) : ViewModel() {

    private val _calendarState: MutableStateFlow<CalendarState> = MutableStateFlow(CalendarState())
    val calendarState = _calendarState.asStateFlow()

    @OptIn(ExperimentalPagerApi::class)
    val pagerState: PagerState = PagerState(1)

    private val TAG = "CalendarControl"

    init {
        viewModelScope.launch {
            getInitialPoints(_calendarState.value.currentDate)
        }
    }

    private suspend fun getInitialPoints(localDate: LocalDate) {
        getDateUseCase.execute(GetDateUseCase.Params(localDate)).collect { result ->
            when (result) {
                is DiaryResult.Error -> {}
                is DiaryResult.Success -> {
                    result.data?.let { data ->
                        val current = data.currentDatePoints.find { it.isCurrentDate }
                        _calendarState.update {
                            it.copy(
                                pages = arrayListOf(
                                    localDate.minusMonths(1).toString() to data.previousDatePoints,
                                    localDate.toString() to data.currentDatePoints,
                                    localDate.plusMonths(1).toString() to data.nextDatePoints
                                ),
                                currentDate = localDate,
                                selected = current,
                                currentSelectedDate = current?.date,
                                currentPoint = current
                            )
                        }
                    }
                }
            }
        }
    }

    fun onSelectionChanged(point: DatePoint) {
        viewModelScope.launch {
            _calendarState.update {
                it.copy(
                    selected = point
                )
            }
        }
    }

    private fun getDatesByLocalDate(date: LocalDate):
            Deferred<List<DatePoint>> {
        val list = viewModelScope.async {
            val result = getDatePointListByLocalDateUseCase.execute(
                GetDatePointListByLocalDateUseCase.Params(date)
            ).first()
            return@async when (result) {
                is DiaryResult.Error -> emptyList()
                is DiaryResult.Success -> result.data ?: emptyList()
            }
        }
        return list
    }

    @OptIn(ExperimentalPagerApi::class)
    fun onPageChanged(page: Int) {
        if (_calendarState.value.pages.isNotEmpty()) {
            viewModelScope.launch {
                val date = LocalDate.parse(_calendarState.value.pages[page].first)
                if (page < _calendarState.value.page) {
                    val prevLocalDate = LocalDate.parse(_calendarState.value.pages[page].first).minusMonths(1)
                    _calendarState.value.pages.firstOrNull { it.first == prevLocalDate.toString() }?.let {
                        _calendarState.update {
                            it.copy(
                                page = if (page == 0) 1 else page,
                                currentSelectedDate = date,
                                isCurrentMonth = date.isCurrentDate(_calendarState.value.currentDate)
                            )
                        }
                    } ?: run {
                        val list = getDatesByLocalDate(prevLocalDate).await()
                        _calendarState.update {
                            it.pages.add(0, prevLocalDate.toString() to list)
                            it.copy(
                                page = if (page == 0) 1 else page,
                                pages = it.pages,
                                currentSelectedDate = date,
                                isCurrentMonth = date.isCurrentDate(_calendarState.value.currentDate)
                            )
                        }
                    }
                    pagerState.scrollToPage(if (page == 0) 1 else page)
                }else if (page > _calendarState.value.page) {
                    val nextLocalDate = date.plusMonths(1)
                    _calendarState.value.pages.firstOrNull { it.first == nextLocalDate.toString() }?.let {
                        _calendarState.update {
                            it.copy(
                                page = page,
                                currentSelectedDate = date,
                                isCurrentMonth = date.isCurrentDate(_calendarState.value.currentDate)
                            )
                        }
                    } ?: run {
                        val list = getDatesByLocalDate(nextLocalDate).await()
                        _calendarState.update {
                            it.pages.add(nextLocalDate.toString() to list)
                            it.copy(
                                page = page,
                                pages = it.pages,
                                currentSelectedDate = date,
                                isCurrentMonth = date.isCurrentDate(_calendarState.value.currentDate)
                            )
                        }
                    }
                    pagerState.scrollToPage(page)
                }
            }
        }
    }

}