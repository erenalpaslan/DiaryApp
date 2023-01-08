package com.easylife.diary.feature.note.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.easylife.diary.core.navigation.DiaryNavigator

/**
 * Created by erenalpaslan on 8.01.2023
 */
@Composable
fun NoteTopBar(doneVisible: Boolean, navigator: DiaryNavigator) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = {
                navigator.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = ""
                )
            }
        },
        actions = {
            if (doneVisible) {
                Button(onClick = {

                }) {
                    Text(text = "Done")
                }
            }
        }
    )
}