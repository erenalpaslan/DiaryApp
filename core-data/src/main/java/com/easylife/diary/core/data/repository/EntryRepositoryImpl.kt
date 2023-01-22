package com.easylife.diary.core.data.repository

import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.data.room.dao.EntryDao
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.preferences.PreferencesKeys
import com.easylife.diary.core.preferences.PreferencesManager
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject

/**
 * Created by erenalpaslan on 9.01.2023
 */
class EntryRepositoryImpl @Inject constructor(
    private val entryDao: EntryDao,
    private val preferencesManager: PreferencesManager
): EntryRepository {

    override suspend fun addEntry(title: String?, description: String?, moodId: Int?) {
        val currentDate = LocalDate.now()
        preferencesManager.getString(PreferencesKeys.LAST_ENTRY_DATE)?.let {
            val prevLocalDate = LocalDate.parse(it)
            val prevHasEntry = entryDao.getEntryCountsByDates(
                prevLocalDate.dayOfMonth.toString(),
                prevLocalDate.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                prevLocalDate.year
            ) > 0
            if (currentDate.toString() != prevLocalDate.toString()
                && prevLocalDate.toString() == currentDate.minusDays(1).toString()
            ) {
                if (prevHasEntry) {
                    val last = preferencesManager.getInt(PreferencesKeys.LAST_CHAIN, 0) + 1
                    preferencesManager.setInt(PreferencesKeys.LAST_CHAIN, last)
                    if (last > preferencesManager.getInt(PreferencesKeys.LONGEST_CHAIN)) {
                        preferencesManager.setInt(PreferencesKeys.LONGEST_CHAIN, last)
                    }
                }else {
                    preferencesManager.setInt(PreferencesKeys.LAST_CHAIN, 0)
                }

            }
        } ?: run {
            preferencesManager.setString(PreferencesKeys.LAST_ENTRY_DATE, currentDate.toString())
        }
        entryDao.addEntry(
            DiaryNote(
                id = 0,
                moodId = moodId,
                title = title,
                description = description,
                date = DateUtil.getCurrentDiaryDate()
            )
        )
    }

    override suspend fun deleteEntry(entry: DiaryNote) {
        entryDao.deleteEntry(entry)
    }

    override suspend fun updateEntry(entry: DiaryNote) {
        entryDao.updateEntry(entry)
    }

    override suspend fun getAllEntries(): List<DiaryNote> {
        return entryDao.getAllEntries()
    }

    override suspend fun getEntryCount(dayOfMonth: String?, month: String?, year: Int?): Int {
        return entryDao.getEntryCountsByDates(dayOfMonth, month, year)
    }

    override suspend fun hasEntryForGivenLocalDate(date: LocalDate): Boolean {
        return entryDao.getEntryCountsByDates(
            date.dayOfMonth.toString(),
            date.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            date.year
        ) > 0
    }

    override suspend fun getEntriesByLocalDate(date: LocalDate): List<DiaryNote> {
        return entryDao.getEntriesByLocalDate(
            date.dayOfMonth.toString(),
            date.month.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            date.year
        )
    }
}