package com.easylife.diary.core.model.enums

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
        0
    ),
    SAD(
        2,
        "Sad",
        0
    ),
    FINE(
        3,
        "Fine",
        0
    ),
    GOOD(
        4,
        "Good",
        0
    ),
    HAPPY(
        5,
        "Happy",
        0
    ),

}