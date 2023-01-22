package com.easylife.diary.core.model.insights

import java.time.LocalDate

/**
 * Created by erenalpaslan on 22.01.2023
 */
data class WeekData(
    val date: LocalDate,
    val hasEntry: Boolean = false,
)
