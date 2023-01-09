package com.easylife.diary.core.common.util

/**
 * Created by erenalpaslan on 9.01.2023
 */
sealed interface DiaryResult<T> {

    data class Error<T>(val message: String?): DiaryResult<T?>

    data class Success<T>(val data: T?): DiaryResult<T?>
}
