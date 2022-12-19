package com.easylife.diary.utils.extensions

import com.easylife.diary.utils.AppResult

/**
 * Created by erenalpaslan on 3.09.2022
 */
fun <T> getErrorMessage(error: AppResult.Error<T>): String? {
    return if (!error.message.isNullOrEmpty()) {
        error.message
    }else {
        ""//WallpaperApp.instance.getString(error.messageId ?: R.string.error_unkown)
    }
}