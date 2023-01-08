package com.easylife.diary.feature.note.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navArgument
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes.noteRoute
import com.easylife.diary.feature.note.NoteScreen
import com.easylife.diary.feature.note.navigation.type.DiaryNoteNavType
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 2.01.2023
 */
@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.noteScreen(navigator: DiaryNavigator) {
    composable(
        route = "$noteRoute?${NoteScreen.NOTE_KEY}={${NoteScreen.NOTE_KEY}}",
        arguments = listOf(navArgument(NoteScreen.NOTE_KEY) {
            defaultValue = null
            nullable = true
            type = DiaryNoteNavType
        })
    ) {
        NoteScreen().Create(
            navigator = navigator,
            viewModel = hiltViewModel()
        )
    }
}