package com.easylife.diary.core.common.extension

import java.time.LocalDate

/**
 * Created by erenalpaslan on 17.01.2023
 */

fun LocalDate.isCurrentDate(currentDate: LocalDate): Boolean {
    return this.month.name == currentDate.month.name &&
        this.year == currentDate.year
}