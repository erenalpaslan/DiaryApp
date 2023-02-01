package com.easylife.diary.core.model

/**
 * Created by erenalpaslan on 10.01.2023
 */
data class EntryGroup(
    val dayOfMonth: String?,
    val month: String?,
    val year: Int?,
    val list: List<DiaryNote> = emptyList()
)
