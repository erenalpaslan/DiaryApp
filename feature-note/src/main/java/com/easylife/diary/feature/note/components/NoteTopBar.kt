package com.easylife.diary.feature.note.components

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.feature.note.R

/**
 * Created by erenalpaslan on 8.01.2023
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NoteTopBar(
    doneVisible: Boolean,
    isEditing: Boolean,
    navigator: DiaryNavigator,
    onDoneClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    onEditClicked: () -> Unit
) {
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
            if (isEditing) {
                IconButton(onClick = {
                    onDeleteClicked()
                }) {
                    Icon(
                        painter = painterResource(id = com.easylife.diary.core.designsystem.R.drawable.ic_trash),
                        contentDescription = "delete icon",
                        tint = red
                    )
                }
                IconButton(onClick = {
                    onEditClicked()
                }) {
                    Icon(
                        painter = painterResource(id = com.easylife.diary.core.designsystem.R.drawable.ic_edit),
                        contentDescription = "edit icon"
                    )
                }
            } else {
                AnimatedVisibility(
                    visible = doneVisible,
                    enter = slideInHorizontally(
                        animationSpec = tween(300, 0)
                    ) { fullWidth ->
                        fullWidth
                    } + fadeIn(),
                    exit = slideOutHorizontally(
                        animationSpec = tween(300, 0)
                    ) { fullWidth ->
                        fullWidth
                    } + fadeOut()
                ) {
                    Button(onClick = {
                        onDoneClicked()
                    }) {
                        Text(text = "Done")
                    }
                }
            }
        }
    )
}