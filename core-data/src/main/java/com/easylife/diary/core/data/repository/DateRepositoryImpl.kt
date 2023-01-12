package com.easylife.diary.core.data.repository

import com.easylife.diary.core.model.DatePoint
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

/**
 * Created by erenalpaslan on 12.01.2023
 */
class DateRepositoryImpl @Inject constructor(
    private val entryRepository: EntryRepository
) : DateRepository {

    override suspend fun createDatePoints(year: Int): List<DatePoint> {
        val list = arrayListOf<DatePoint>()
        val cal = Calendar.getInstance()
        cal.set(Calendar.YEAR, year)

        Calendar.getInstance().let { calendar ->
            calendar.set(Calendar.MONTH, 0)
            calendar.set(Calendar.YEAR, year)
            for (i in 0 until 12) {
                val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                for (x in 0 until maxDay) {
                    cal.set(Calendar.DAY_OF_MONTH, (x + 1))
                    cal.set(Calendar.MONTH, i)
                    val dayOfMonth = cal.get(Calendar.DAY_OF_MONTH).toString()
                    val month =
                        cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
                    if (x > 0 && list.isNotEmpty() && month != list.last().month) {
                        break
                    }
                    val count = entryRepository.getEntryCount(
                        dayOfMonth = dayOfMonth,
                        month = month,
                        year = year
                    )
                    list.add(
                        DatePoint(
                            dayOfMonth = dayOfMonth,
                            day = cal.getDisplayName(
                                Calendar.DAY_OF_WEEK,
                                Calendar.SHORT,
                                Locale.getDefault()
                            ),
                            month = month,
                            count = count,
                            year = year
                        )
                    )
                }
                calendar.add(Calendar.MONTH, 1)
            }
        }

        return list
    }

}