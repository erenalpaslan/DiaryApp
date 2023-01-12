package com.easylife.diary.core.data.mapper

/**
 * Created by erenalpaslan on 12.01.2023
 */
abstract class Mapper<T, R> {

    abstract fun transform(input: T): R

}