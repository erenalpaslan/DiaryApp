package com.easylife.diary.feature.diary.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryScreenDataList(
    data: List<String>
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(data) {
            DiaryListItem()
        }
    }
}