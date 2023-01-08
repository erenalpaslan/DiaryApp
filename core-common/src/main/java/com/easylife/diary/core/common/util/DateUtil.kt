package com.easylife.diary.core.common.util

import com.easylife.diary.core.model.DiaryDate
import com.easylife.diary.core.model.DiaryNote
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Created by erenalpaslan on 8.01.2023
 */
object DateUtil {

    private const val DEFAULT_PATTERN = "d MMM yyyy, h:mm a"

    fun getCurrentDate(pattern: String? = DEFAULT_PATTERN): String {
        val current = Calendar.getInstance().time
        val formatter = SimpleDateFormat(pattern, Locale.getDefault())
        return formatter.format(current)
    }

    fun DiaryDate.formattedDate(): String? {
        val calendar = Calendar.getInstance()
        calendar.time = Date(this.timestamp)
        val formatter = SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault())
        return formatter.format(calendar.time)
    }
}