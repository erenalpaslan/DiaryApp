package com.easylife.diary.feature.diary.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryScreenDataList(
    data: List<DiaryNote>,
    onItemClicked: (DiaryNote) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(data) { entry ->
            DiaryListItem(
                entry,
                onClick = {
                    onItemClicked(entry)
                }
            )
        }
    }
}