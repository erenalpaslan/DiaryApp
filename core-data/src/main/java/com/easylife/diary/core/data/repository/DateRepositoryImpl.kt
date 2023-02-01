package com.easylife.diary.core.data.repository

import android.util.Log
import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.data.room.dao.EntryDao
import com.easylife.diary.core.model.calendar.CalendarDates
import com.easylife.diary.core.model.calendar.DatePoint
import com.easylife.diary.core.model.insights.WeekData
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

/**
 * Created by erenalpaslan on 12.01.2023
 */
class DateRepositoryImpl @Inject constructor(
    private val entryDao: EntryDao
) : DateRepository {

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

    override suspend fun getLastWeekData(): List<WeekData> {
        val date = LocalDate.now()
        val list = arrayListOf<WeekData>()
        (0..6).forEach {
            val current = date.minusDays(it.toLong())
            val weekData = WeekData(
                date = current,
                hasEntry = entryDao.getEntryCountsByDates(
                    current.dayOfMonth.toString(),
                    current.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    current.year
                ) > 0
            )
            list.add(weekData)
        }
        return list.reversed()
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
        Log.d("DateControl", "Prev ADDED => $points")
        val currentDayOfMonth = today.dayOfMonth
        val currentMonth = today.monthValue
        val currentYear = today.year
        (1..date.lengthOfMonth()).forEach { dayOfMonth ->
            points.add(
                DatePoint(
                    date = date.withDayOfMonth(dayOfMonth),
                    isCurrentDate = currentDayOfMonth == dayOfMonth && currentMonth == date.monthValue && currentYear == date.year,
                )
            )
        }
        Log.d("DateControl", "Current ADDED => $points")
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
        Log.d("DateControl", "Next ADDED => $points")
        return points
    }

}