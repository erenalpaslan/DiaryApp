package com.easylife.diary.feature.note.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.easylife.diary.feature.note.enums.MoodTypes

/**
 * Created by erenalpaslan on 8.01.2023
 */
@Composable
fun MoodDialog(
    show: MutableState<Boolean>,
    onMoodSelected: (MoodTypes) -> Unit
) {
    val moods = remember {
        MoodTypes.get()
    }

    val close: () -> Unit = remember {
        {
            show.value = false
        }
    }

    if (show.value) {
        AlertDialog(
            shape = MaterialTheme.shapes.large,
            onDismissRequest = {
                close()
            },
            confirmButton = {},
            title = {
                Text(
                    text = "How are you?",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        moods.forEach { mood ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clip(MaterialTheme.shapes.large)
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(horizontal = 8.dp)
                                    .clickable {
                                        onMoodSelected(mood)
                                        close()
                                    }
                            ) {
                                Image(
                                    painter = painterResource(id = mood.icon),
                                    contentDescription = mood.moodName,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            },
        )
    }
}