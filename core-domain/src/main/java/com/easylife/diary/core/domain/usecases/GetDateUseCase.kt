package com.easylife.diary.core.domain.usecases

import android.util.Log
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.designsystem.base.BaseUseCase
import com.easylife.diary.core.model.DatePoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 12.01.2023
 */
class GetDateUseCase(
    private val dispatchers: DiaryDispatchers,
    private val dateRepository: DateRepository
): BaseUseCase<List<DatePoint>, Unit>() {
    override suspend fun execute(params: Unit): Flow<DiaryResult<List<DatePoint>?>> = flow {
        try {
            val dates = dateRepository.createDatePoints(2023)
            Log.d("DateControl", "=> $dates")
        }catch (e: Exception) {
            Log.d("DateControl", "=> ${e.message}")
        }
        emit(DiaryResult.Success(emptyList<DatePoint>()))
    }.flowOn(dispatchers.io)
}