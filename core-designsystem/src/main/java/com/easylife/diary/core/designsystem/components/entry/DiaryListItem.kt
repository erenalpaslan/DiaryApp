package com.easylife.diary.core.designsystem.components.entry

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.enums.MoodTypes
import com.easylife.diary.core.model.DiaryNote

/**
 * Created by erenalpaslan on 2.01.2023
 */
@Composable
fun DiaryListItem(diaryNote: DiaryNote, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .fillMaxSize()
    ) {
        Text(text = diaryNote.date?.hours ?: "", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        if (diaryNote.moodId != null) {
            Image(
                painter = painterResource(id = MoodTypes.from(diaryNote.moodId ?: 0)?.icon ?: 0),
                contentDescription = "mood icon",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        if (!diaryNote.title.isNullOrEmpty()) {
            Text(
                text = diaryNote.title ?: "",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        if (!diaryNote.description.isNullOrEmpty()) {
            Text(text = diaryNote.description ?: "", style = MaterialTheme.typography.bodyLarge)
        }
    }

}
