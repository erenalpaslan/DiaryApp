package com.easylife.diary.utils

import androidx.annotation.StringRes

/**
 * Created by erenalpaslan on 30.08.2022
 */
sealed class AppResult <T> {
    data class Success<T>(val data: T?): AppResult<T>()
    data class Error<T>(val message: String? = null, @StringRes val messageId: Int? = null): AppResult<T>()
}