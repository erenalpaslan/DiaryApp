package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.model.DiaryNote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by erenalpaslan on 10.01.2023
 */
class EditEntryUseCase @Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val entryRepository: EntryRepository
): BaseUseCase<Boolean, EditEntryUseCase.Params>() {

    data class Params(
        val entry: DiaryNote
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<Boolean?>> = flow {
        try {
            entryRepository.updateEntry(params.entry)
            emit(DiaryResult.Success(true))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}