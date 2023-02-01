package com.easylife.diary.core.designsystem.components.entry

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup

/**
 * Created by erenalpaslan on 15.01.2023
 */
@Composable
fun EntryList(
    list: List<EntryGroup>,
    onItemClicked: (DiaryNote) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list) { entryGroup ->
            EntryGroupItem(entryGroup) {
                onItemClicked(it)
            }
        }
    }
}
