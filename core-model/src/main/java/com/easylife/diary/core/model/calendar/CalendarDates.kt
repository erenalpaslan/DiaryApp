package com.easylife.diary.core.model.calendar

import java.time.LocalDate

/**
 * Created by erenalpaslan on 14.01.2023
 */
data class CalendarDates(
    var currentDatePoints: List<DatePoint>,
    val currentLocalDate: LocalDate,
    val previousDatePoints: List<DatePoint>,
    val previousLocalDate: LocalDate,
    val nextDatePoints: List<DatePoint>,
    val nextLocalDate: LocalDate
)
