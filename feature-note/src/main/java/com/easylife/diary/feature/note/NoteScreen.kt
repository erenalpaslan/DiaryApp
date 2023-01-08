package com.easylife.diary.feature.note

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
import com.easylife.diary.feature.note.components.NoteTopBar

/**
 * Created by erenalpaslan on 2.01.2023
 */
class NoteScreen : BaseScreen<NoteViewModel>() {
    @Composable
    override fun Screen() {
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        Content(uiState)
    }

    @Composable
    fun Content(uiState: NoteUiState) {
        Scaffold(
            topBar = {
                NoteTopBar(
                    uiState = uiState,
                    navigator = navigator
                )
            }
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(it)
                    .padding(top = 16.dp)
                    .fillMaxSize()
            ) {
                val (dateRef, inputFieldRef, bottomRef) = createRefs()
                Column(modifier = Modifier.constrainAs(dateRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                    Text(
                        text = uiState.date ?: "3 Jan 2023, 07:33 PM",
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider()
                }
                Column(modifier = Modifier.constrainAs(inputFieldRef) {
                    top.linkTo(dateRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomRef.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }) {
                    DiaryTitleTextField(uiState.title)
                    DiaryEntryTextField(uiState.description)
                }
                Column(modifier = Modifier.constrainAs(bottomRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }) {
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
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
        }
    }

    companion object {
        const val NOTE_KEY = "NOTE_KEY"
    }
}