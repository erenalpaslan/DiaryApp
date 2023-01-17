package com.easylife.diary.core.designsystem.components.calendar

import com.easylife.diary.core.model.calendar.DatePoint
import java.time.LocalDate

/**
 * Created by erenalpaslan on 14.01.2023
 */
data class CalendarState(
    val currentDate: LocalDate = LocalDate.now(),
    val currentPoint: DatePoint? = null,
    var currentSelectedDate: LocalDate? = LocalDate.now(),
    var selected: DatePoint? = null,
    var page: Int = 1,
    var isCurrentMonth: Boolean = true,
    val pages: ArrayList<Pair<String, List<DatePoint>>> = arrayListOf()
) {
    fun selectCurrent() {
        currentSelectedDate = currentPoint?.date
        selected = currentPoint
        pages.indexOfFirst { it.first == currentSelectedDate.toString() }.let {
            if (it != -1) {
                page = it
            }
        }

    }
}