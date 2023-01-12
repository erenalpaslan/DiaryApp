package com.easylife.diary.core.data.repository

import com.easylife.diary.core.model.DatePoint

/**
 * Created by erenalpaslan on 12.01.2023
 */
interface DateRepository {

    suspend fun createDatePoints(year: Int): List<DatePoint>

}