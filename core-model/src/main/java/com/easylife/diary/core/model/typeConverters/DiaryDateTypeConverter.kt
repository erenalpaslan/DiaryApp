package com.easylife.diary.core.model.typeConverters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.easylife.diary.core.model.DiaryDate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

/**
 * Created by erenalpaslan on 9.01.2023
 */
@ProvidedTypeConverter
class DiaryDateTypeConverter @Inject constructor(
    private val gson: Gson
) {
    @TypeConverter
    fun toString(diaryDate: DiaryDate?): String? {
        if (diaryDate == null) {
            return null
        }
        val type: Type = object : TypeToken<DiaryDate?>(){}.type
        return gson.toJson(diaryDate, type)
    }

    @TypeConverter
    fun fromString(diaryDate: String?): DiaryDate? {
        if (diaryDate == null) {
            return null
        }
        val type: Type = object : TypeToken<DiaryDate?>(){}.type
        return gson.fromJson(diaryDate, type)
    }
}