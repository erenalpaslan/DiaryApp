package com.easylife.diary.core.domain.usecases

import android.util.Log
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.model.calendar.CalendarDates
import com.easylife.diary.core.model.calendar.DatePoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

/**
 * Created by erenalpaslan on 12.01.2023
 */
class GetDateUseCase(
    private val dispatchers: DiaryDispatchers,
    private val dateRepository: DateRepository,
    private val entryRepository: EntryRepository
): BaseUseCase<CalendarDates, GetDateUseCase.Params>() {

    data class Params(
        val date: LocalDate
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<CalendarDates?>> = flow {
        try {
            val dates = dateRepository.getCalendarDates(params.date)
            dates.currentDatePoints.forEach {
                it.apply {
                    this.hasEntry = entryRepository.hasEntryForGivenLocalDate(this.date)
                }
            }
            emit(DiaryResult.Success(dates))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)
}