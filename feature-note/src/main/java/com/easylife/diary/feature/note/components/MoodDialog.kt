package com.easylife.diary.feature.note.components

import android.view.Gravity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.easylife.diary.core.designsystem.components.CustomDialogPosition
import com.easylife.diary.core.designsystem.components.customDialogModifier
import com.easylife.diary.core.model.enums.MoodTypes

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
            modifier = Modifier
                .padding(bottom = 124.dp)
                .systemBarsPadding(),
            onDismissRequest = {
                close()
            },
            confirmButton = {},
            text = {
                Card(
                    shape = MaterialTheme.shapes.large
                ) {
                    Spacer(modifier = Modifier.height(32.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        items(moods) {
                            Box() {
                                Text(text = it.moodName)
                            }
                        }
                    }
                }
            }
        )
    }
}