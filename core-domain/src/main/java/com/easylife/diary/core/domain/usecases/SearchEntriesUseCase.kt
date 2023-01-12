package com.easylife.diary.core.domain.usecases

import android.util.Log
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.mapper.EntryGroupMapper
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.designsystem.base.BaseUseCase
import com.easylife.diary.core.model.EntryGroup
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by erenalpaslan on 12.01.2023
 */
class SearchEntriesUseCase @Inject constructor(
    private val dispatchers: DiaryDispatchers,
    private val entryRepository: EntryRepository
): BaseUseCase<List<EntryGroup>, SearchEntriesUseCase.Params>() {

    data class Params(
        val text: String?,
        val list: List<EntryGroup>
    )

    override suspend fun execute(params: Params): Flow<DiaryResult<List<EntryGroup>?>> = flow {
        try {
            val filtered = params.list.flatMap { it.list }.filter {
                it.description?.contains(params.text ?: "") == true ||
                        it.title?.contains(params.text ?: "") == true
            }
            emit(DiaryResult.Success(EntryGroupMapper.transform(filtered)))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}