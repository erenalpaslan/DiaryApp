package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.model.insights.WeekData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 22.01.2023
 */
class GetWeekDataUseCase(
    private val dispatchers: DiaryDispatchers,
    private val dateRepository: DateRepository
): BaseUseCase<List<WeekData>, Unit>() {

    override suspend fun execute(params: Unit): Flow<DiaryResult<List<WeekData>?>> = flow {
        try {
            val list = dateRepository.getLastWeekData()
            emit(DiaryResult.Success(list))
        }catch (e: Exception) {
            emit(DiaryResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)

}