package com.easylife.diary.feature.diary.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.components.entry.EntryGroupItem
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryScreenDataList(
    data: List<EntryGroup>,
    onItemClicked: (DiaryNote) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(data) { entryGroup ->
            EntryGroupItem(entryGroup) {
                onItemClicked(it)
            }
        }
    }
}