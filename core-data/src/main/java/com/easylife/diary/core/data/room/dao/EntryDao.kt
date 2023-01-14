package com.easylife.diary.core.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 9.01.2023
 */
@Dao
interface EntryDao {

    @Insert
    suspend fun addEntry(entry: DiaryNote)

    @Update
    suspend fun updateEntry(entry: DiaryNote)

    @Delete
    suspend fun deleteEntry(entry: DiaryNote)

    @Query("SELECT * FROM Entries")
    suspend fun getAllEntries(): List<DiaryNote>

    @Query("SELECT COUNT(*) FROM Entries WHERE dayOfMonth = :dayOfMonth AND shortMonth = :month AND year = :year")
    suspend fun getEntryCountsByDates(dayOfMonth: String?, month: String?, year: Int?): Int

}