package com.easylife.diary.feature.note.navigation.type

import android.os.Bundle
import androidx.navigation.NavType
import com.easylife.diary.core.model.DiaryNote
import com.google.gson.Gson

/**
 * Created by erenalpaslan on 7.01.2023
 */
object DiaryNoteNavType: NavType<DiaryNote?>(isNullableAllowed = true) {

    override fun get(bundle: Bundle, key: String): DiaryNote? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): DiaryNote {
        return Gson().fromJson(value, DiaryNote::class.javaObjectType)
    }

    override fun put(bundle: Bundle, key: String, value: DiaryNote?) {
        bundle.putParcelable(key, value)
    }

}