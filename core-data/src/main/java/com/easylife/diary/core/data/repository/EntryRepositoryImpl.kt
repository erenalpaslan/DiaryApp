package com.easylife.diary.core.data.repository

import com.easylife.diary.core.common.util.DateUtil
import com.easylife.diary.core.data.room.dao.EntryDao
import com.easylife.diary.core.model.DiaryNote
import javax.inject.Inject

/**
 * Created by erenalpaslan on 9.01.2023
 */
class EntryRepositoryImpl @Inject constructor(
    private val entryDao: EntryDao
): EntryRepository {

    override suspend fun addEntry(title: String?, description: String?, moodId: Int?) {
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
}