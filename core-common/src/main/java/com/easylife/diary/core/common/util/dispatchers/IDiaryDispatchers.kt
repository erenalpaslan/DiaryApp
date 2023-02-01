package com.easylife.diary.core.common.util.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

abstract class IDiaryDispatchers {

    abstract val main: CoroutineDispatcher

    abstract val io: CoroutineDispatcher

    abstract val default: CoroutineDispatcher
}