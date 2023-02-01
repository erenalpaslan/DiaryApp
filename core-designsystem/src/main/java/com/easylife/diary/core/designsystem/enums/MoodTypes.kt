package com.easylife.diary.core.designsystem.enums

import com.easylife.diary.core.designsystem.R

/**
 * Created by erenalpaslan on 7.01.2023
 */
enum class MoodTypes(
    val id: Int,
    val moodName: String,
    val icon: Int
) {
    UNHAPPY(
        1,
        "Unhappy",
        R.drawable.ic_unhappy
    ),
    SAD(
        2,
        "Sad",
        R.drawable.ic_sad
    ),
    FINE(
        3,
        "Fine",
        R.drawable.ic_normal
    ),
    GOOD(
        4,
        "Good",
        R.drawable.ic_good
    ),
    HAPPY(
        5,
        "Happy",
        R.drawable.ic_happy
    );

    companion object {
        fun get(): List<MoodTypes> = MoodTypes.values().toList()
        fun from(id: Int) = MoodTypes.values().firstOrNull { it.id == id }
    }

}