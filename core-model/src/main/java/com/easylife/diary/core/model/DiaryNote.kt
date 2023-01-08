package com.easylife.diary.core.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by erenalpaslan on 7.01.2023
 */
@Parcelize
data class DiaryNote(
    val id: Int,
    val moodId: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val date: DiaryDate
): Parcelable
