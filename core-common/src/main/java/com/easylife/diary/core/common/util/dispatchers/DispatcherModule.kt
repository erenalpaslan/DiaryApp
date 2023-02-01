package com.easylife.diary.core.common.util.dispatchers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by erenalpaslan on 9.01.2023
 */
@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @Provides
    @Singleton
    fun providesDiaryDispatchers(): DiaryDispatchers {
        return DiaryDispatchers()
    }

}