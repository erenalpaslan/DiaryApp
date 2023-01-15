package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.DiaryResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by erenalpaslan on 9.01.2023
 */
abstract class BaseUseCase<T, R>() {
    abstract suspend fun execute(params: R): Flow<DiaryResult<T?>>
}