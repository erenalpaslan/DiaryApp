package com.easylife.diary.core.domain.usecases

import android.util.Log
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.designsystem.base.BaseUseCase
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by erenalpaslan on 9.01.2023
 */
class GetAllEntriesUseCase @Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val entryRepository: EntryRepository
): BaseUseCase<List<EntryGroup>, Unit>() {

    override suspend fun execute(params: Unit): Flow<DiaryResult<List<EntryGroup>?>> = flow {
        try {
            val entries = entryRepository.getAllEntries()
            val entryGroup = entries.groupBy { "${it.date?.dayOfMonth} ${it.date?.shortMonth} ${it.date?.year}" }.map { (key, value) ->
                val keys = key.split(" ")
                EntryGroup(
                    dayOfMonth = keys[0],
                    month = keys[1],
                    year = keys[2].toInt(),
                    list = value
                )
            }
            emit(DiaryResult.Success(entryGroup))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}