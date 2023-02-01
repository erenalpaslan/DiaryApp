package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.mapper.EntryGroupMapper
import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.model.EntryGroup
import com.easylife.diary.core.model.calendar.DatePoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import javax.inject.Inject

/**
 * Created by erenalpaslan on 15.01.2023
 */
class GetEntryGroupByLocalDateUseCase@Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val entryRepository: EntryRepository
) : BaseUseCase<List<EntryGroup>, GetEntryGroupByLocalDateUseCase.Params>() {

    data class Params(
        val date: LocalDate
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<List<EntryGroup>?>> = flow {
        try {
            val entries = entryRepository.getEntriesByLocalDate(params.date)
            emit(DiaryResult.Success(EntryGroupMapper.transform(entries)))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)
}