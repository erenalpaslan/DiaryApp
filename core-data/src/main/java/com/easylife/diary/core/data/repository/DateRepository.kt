package com.easylife.diary.core.data.repository

import com.easylife.diary.core.model.calendar.CalendarDates
import com.easylife.diary.core.model.calendar.DatePoint
import com.easylife.diary.core.model.insights.WeekData
import java.time.LocalDate

/**
 * Created by erenalpaslan on 12.01.2023
 */
interface DateRepository {

    suspend fun getCalendarDates(currentDate: LocalDate): CalendarDates

    suspend fun getDatePointsByGivenLocalDate(localDate: LocalDate): List<DatePoint>

    suspend fun getLastWeekData(): List<WeekData>

}