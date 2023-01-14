package com.easylife.diary.core.designsystem.components.calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.domain.usecases.GetDateUseCase
import com.easylife.diary.core.model.calendar.DatePoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.TextStyle
import java.time.temporal.TemporalField
import java.util.Locale
import javax.inject.Inject

/**
 * Created by erenalpaslan on 14.01.2023
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getDateUseCase: GetDateUseCase
): ViewModel() {

    private val _calendarState: MutableStateFlow<CalendarState> = MutableStateFlow(CalendarState())
    val calendarState = _calendarState.asStateFlow()

    init {
        viewModelScope.launch {
            getPoints(_calendarState.value.currentDate)
        }
    }

    private suspend fun getPoints(localDate: LocalDate) {
        getDateUseCase.execute(GetDateUseCase.Params(localDate)).collect { result ->
            when(result) {
                is DiaryResult.Error -> {}
                is DiaryResult.Success -> {
                    _calendarState.update {
                        it.copy(
                            currentDatePoints = result.data?.currentDatePoints ?: emptyList(),
                            previousDatePoints = result.data?.previousDatePoints ?: emptyList(),
                            nextDatePoints = result.data?.nextDatePoints ?: emptyList(),
                            currentDate = localDate
                        )
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

    fun onPageChanged(page: Int) {
        viewModelScope.launch {
            when(page) {
                0 -> {
                    getPoints(_calendarState.value.currentDate.minusMonths(1))
                }
                2 -> {
                    getPoints(_calendarState.value.currentDate.plusMonths(1))
                }
                else -> {}
            }
            _calendarState.update {
                it.copy(
                    page = page
                )
            }
        }
    }

}