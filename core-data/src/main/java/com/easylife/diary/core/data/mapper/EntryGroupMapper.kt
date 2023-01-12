package com.easylife.diary.core.data.mapper

import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup

/**
 * Created by erenalpaslan on 12.01.2023
 */
object EntryGroupMapper: Mapper<List<DiaryNote>, List<EntryGroup>>() {

    override fun transform(input: List<DiaryNote>): List<EntryGroup> {
        return input.groupBy { "${it.date?.dayOfMonth} ${it.date?.shortMonth} ${it.date?.year}" }.map { (key, value) ->
            val keys = key.split(" ")
            EntryGroup(
                dayOfMonth = keys[0],
                month = keys[1],
                year = keys[2].toInt(),
                list = value
            )
        }.asReversed()
    }

}