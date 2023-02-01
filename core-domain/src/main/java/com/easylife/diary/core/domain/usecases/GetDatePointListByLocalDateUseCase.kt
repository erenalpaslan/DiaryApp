package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.model.calendar.DatePoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import javax.inject.Inject

/**
 * Created by erenalpaslan on 14.01.2023
 */
class GetDatePointListByLocalDateUseCase @Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val dateRepository: DateRepository,
    private val entryRepository: EntryRepository
) : BaseUseCase<List<DatePoint>, GetDatePointListByLocalDateUseCase.Params>() {

    data class Params(
        val date: LocalDate
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<List<DatePoint>?>> = flow {
        try {
            val points = dateRepository.getDatePointsByGivenLocalDate(params.date)
            points.forEach {
                it.apply {
                    this.hasEntry = entryRepository.hasEntryForGivenLocalDate(this.date)
                }
            }
            emit(DiaryResult.Success(points))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)
}