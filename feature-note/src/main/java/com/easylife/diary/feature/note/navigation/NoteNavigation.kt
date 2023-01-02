package com.easylife.diary.feature.note.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.easylife.diary.feature.note.NoteScreen
import com.google.accompanist.navigation.animation.composable

/**
 * Created by erenalpaslan on 2.01.2023
 */
const val noteRoute = "note_route"

fun NavController.navigateToNote(navOptions: NavOptions? = null) {
    this.navigate(noteRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.noteScreen() {
    composable(route = noteRoute) {
        NoteScreen().Create(viewModel = hiltViewModel())
    }
}