package com.easylife.diary.core.domain.usecases

import com.easylife.diary.core.common.util.dispatchers.DiaryDispatchers
import com.easylife.diary.core.data.repository.DateRepository
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

    @Provides
    fun providesSearchEntryUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): SearchEntriesUseCase {
        return SearchEntriesUseCase(dispatchers, entryRepository)
    }

    @Provides
    fun providesDateUseCase(
        dispatchers: DiaryDispatchers,
        dateRepository: DateRepository,
        entryRepository: EntryRepository
    ): GetDateUseCase {
        return GetDateUseCase(dispatchers, dateRepository, entryRepository)
    }

    @Provides
    fun providesDatePointListByLocalDateUseCase(
        dispatchers: DiaryDispatchers,
        dateRepository: DateRepository,
        entryRepository: EntryRepository
    ): GetDatePointListByLocalDateUseCase {
        return GetDatePointListByLocalDateUseCase(dispatchers, dateRepository, entryRepository)
    }

    @Provides
    fun providesEntryGroupByLocalDateUseCase(
        dispatchers: DiaryDispatchers,
        entryRepository: EntryRepository
    ): GetEntryGroupByLocalDateUseCase {
        return GetEntryGroupByLocalDateUseCase(dispatchers, entryRepository)
    }

    @Provides
    fun providesGetWeekDateUseCase(
        dispatchers: DiaryDispatchers,
        dateRepository: DateRepository
    ): GetWeekDataUseCase {
        return GetWeekDataUseCase(dispatchers, dateRepository)
    }
}