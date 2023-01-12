package com.easylife.diary.core.data.di

import com.easylife.diary.core.data.repository.DateRepository
import com.easylife.diary.core.data.repository.DateRepositoryImpl
import com.easylife.diary.core.data.repository.EntryRepository
import com.easylife.diary.core.data.repository.EntryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by erenalpaslan on 9.01.2023
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesEntryRepository(
        repositoryImpl: EntryRepositoryImpl
    ): EntryRepository

    @Binds
    abstract fun providesDateRepository(
        repositoryImpl: DateRepositoryImpl
    ): DateRepository

}