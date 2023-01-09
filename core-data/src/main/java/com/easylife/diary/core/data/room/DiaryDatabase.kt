package com.easylife.diary.core.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easylife.diary.core.data.room.dao.EntryDao
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 9.01.2023
 */
@Database(
    entities = [
        DiaryNote::class
    ],
    version = 1
)
abstract class DiaryDatabase: RoomDatabase() {
    abstract fun entryDao(): EntryDao

    companion object{
        const val DB_NAME = "DiaryDatabase"
    }
}