package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.EntryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

/**
 * Created by erenalpaslan on 9.01.2023
 */
@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun providesGetAllEntriesUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): GetAllEntriesUseCase {
        return GetAllEntriesUseCase(dispatchers, entryRepository)
    }

    @Provides
    fun providesAddEntryUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): AddEntryUseCase {
        return AddEntryUseCase(dispatchers, entryRepository)
    }

    @Provides
    fun providesEditEntryUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): EditEntryUseCase {
        return EditEntryUseCase(dispatchers, entryRepository)
    }

    @Provides
    fun providesDeleteEntryUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): DeleteEntryUseCase {
        return DeleteEntryUseCase(dispatchers, entryRepository)
    }

}