package com.easylife.diary.core.designsystem.components.calendar

import com.easylife.diary.core.model.calendar.DatePoint
import java.time.LocalDate

/**
 * Created by erenalpaslan on 14.01.2023
 */
data class CalendarState(
    val currentDate: LocalDate = LocalDate.now(),
    val currentSelectedDate: LocalDate? = LocalDate.now(),
    val selected: DatePoint? = null,
    val page: Int = 1,
    val isCurrentMonth: Boolean = true,
    val pages: ArrayList<Pair<String, List<DatePoint>>> = arrayListOf()
)