package com.easylife.diary.core.data.repository

import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.model.DiaryNote
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

/**
 * Created by erenalpaslan on 9.01.2023
 */
interface EntryRepository {

    suspend fun addEntry(title: String?, description: String?, moodId: Int?)

    suspend fun deleteEntry(entry: DiaryNote)

    suspend fun updateEntry(entry: DiaryNote)

    suspend fun getAllEntries(): List<DiaryNote>

    suspend fun getEntryCount(dayOfMonth: String?, month: String?, year: Int?): Int

    suspend fun hasEntryForGivenLocalDate(date: LocalDate): Boolean

    suspend fun getEntriesByLocalDate(date: LocalDate): List<DiaryNote>

}