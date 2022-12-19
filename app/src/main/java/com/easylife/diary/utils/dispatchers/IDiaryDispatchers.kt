package com.easylife.diary.utils.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

abstract class IDiaryDispatchers {

    abstract val main: CoroutineDispatcher

    abstract val io: CoroutineDispatcher

    abstract val default: CoroutineDispatcher
}