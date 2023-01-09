package com.easylife.diary.feature.diary.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryListItem(diaryNote: DiaryNote, onClick: () -> Unit) {
    Text(
        text = "Entry => ${diaryNote.title}, ${diaryNote.description}, ${diaryNote.moodId}",
        modifier = Modifier.clickable {
            onClick()
        }
    )
}
