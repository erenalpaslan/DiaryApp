package com.easylife.diary.core.data.repository

import android.util.Log
import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.model.calendar.CalendarDates
import com.easylife.diary.core.model.calendar.DatePoint
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

/**
 * Created by erenalpaslan on 12.01.2023
 */
class DateRepositoryImpl @Inject constructor() : DateRepository {

    override suspend fun getCalendarDates(currentDate: LocalDate): CalendarDates {
        val prevLocalDate = currentDate.minusMonths(1)
        val nextLocalDate = currentDate.plusMonths(1)

        return CalendarDates(
            currentDatePoints = createDatePointsForGiven(currentDate, currentDate),
            currentLocalDate = currentDate,
            previousDatePoints = createDatePointsForGiven(prevLocalDate, currentDate),
            previousLocalDate = prevLocalDate,
            nextDatePoints = createDatePointsForGiven(nextLocalDate, currentDate),
            nextLocalDate = nextLocalDate
        )
    }

    override suspend fun getDatePointsByGivenLocalDate(localDate: LocalDate): List<DatePoint> {
        return createDatePointsForGiven(
            date = localDate,
            today = LocalDate.now()
        )
    }

    private fun createDatePointsForGiven(date: LocalDate, today: LocalDate): List<DatePoint> {
        val firstDateName =
            date.withDayOfMonth(1).dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
        val startColumn = DateUtil.getDayNameList().indexOf(firstDateName)
        val prevLocalDate = date.minusMonths(1)
        val nextLocalDate = date.plusMonths(1)
        val points = arrayListOf<DatePoint>()
        val prevMax = prevLocalDate.lengthOfMonth()
        ((prevMax - startColumn)..prevMax).forEach { dayOfMonth ->
            points.add(
                DatePoint(
                    date = prevLocalDate.withDayOfMonth(dayOfMonth),
                    active = false
                )
            )
        }
        val currentDayOfMonth = today.dayOfMonth
        val currentMonth = today.monthValue
        val currentYear = today.year
        (1..date.lengthOfMonth()).forEach { dayOfMonth ->
            points.add(
                DatePoint(
                    date = date.withDayOfMonth(dayOfMonth),
                    isCurrentDate = currentDayOfMonth == dayOfMonth && currentMonth == date.monthValue && currentYear == date.year
                )
            )
        }
        var nextDayOfMonth = 1
        (points.size..42).forEach { _ ->
            points.add(
                DatePoint(
                    date = nextLocalDate.withDayOfMonth(nextDayOfMonth),
                    active = false,
                )
            )
            nextDayOfMonth++
        }
        return points
    }

}