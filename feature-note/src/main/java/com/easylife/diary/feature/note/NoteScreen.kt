package com.easylife.diary.feature.note

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.components.DiaryEntryTextField
import com.easylife.diary.core.designsystem.components.DiaryTitleTextField
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.feature.note.components.MoodDialog
import com.easylife.diary.feature.note.components.NoteTopBar

/**
 * Created by erenalpaslan on 2.01.2023
 */
class NoteScreen : BaseScreen<NoteViewModel>() {
    @Composable
    override fun Screen() {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle(NoteUiState())
        Content(uiState)
    }

    @Composable
    fun Content(uiState: NoteUiState) {
        val showMoodDialogState = remember {
            mutableStateOf(false)
        }

        Scaffold(
            topBar = {
                NoteTopBar(
                    doneVisible = uiState.doneVisible,
                    navigator = navigator
                ) {
                    viewModel.onDoneClicked()
                }
            },
            bottomBar = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                        OutlinedIconButton(
                            onClick = { showMoodDialogState.value = true },
                            shape = MaterialTheme.shapes.small
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add_mood),
                                contentDescription = "Add mood icon"
                            )
                        }
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            shape = MaterialTheme.shapes.small
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add_image),
                                contentDescription = "Add mood icon"
                            )
                        }
                    }
                }
            }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                val (dateRef, inputFieldRef) = createRefs()
                Column(modifier = Modifier.constrainAs(dateRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                    Text(
                        text = uiState.date,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                }
                Column(modifier = Modifier.constrainAs(inputFieldRef) {
                    top.linkTo(dateRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }) {
                    uiState.mood?.let { mood ->
                        Spacer(modifier = Modifier.height(8.dp))
                        Row() {
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(onClick = {
                                showMoodDialogState.value = true
                            }) {
                                Image(
                                    painter = painterResource(id = mood.icon),
                                    contentDescription = mood.moodName,
                                    modifier = Modifier.size(56.dp)
                                )
                            }
                        }
                    }
                    DiaryTitleTextField(uiState.title) { title ->
                        viewModel.onTitleChanged(title)
                    }
                    DiaryEntryTextField(uiState.description) { description ->
                        viewModel.onDescriptionChanged(description)
                    }
                }
            }
        }

        MoodDialog(
            show = showMoodDialogState,
            onMoodSelected = {
                viewModel.onMoodSelected(it)
            }
        )
    }
}