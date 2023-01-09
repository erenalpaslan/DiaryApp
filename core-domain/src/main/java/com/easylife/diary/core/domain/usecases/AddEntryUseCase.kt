package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.designsystem.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by erenalpaslan on 9.01.2023
 */
class AddEntryUseCase @Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val entryRepository: EntryRepository
): BaseUseCase<Unit, AddEntryUseCase.Params>() {

    data class Params(
        val title: String?,
        val description: String?,
        val moodId: Int?
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<Unit?>> = flow {
        try {
            entryRepository.addEntry(params.title, params.description, params.moodId)
            emit(DiaryResult.Success(Unit))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}