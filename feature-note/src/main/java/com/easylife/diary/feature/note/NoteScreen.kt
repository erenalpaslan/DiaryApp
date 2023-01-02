package com.easylife.diary.feature.note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 2.01.2023
 */
class NoteScreen : BaseScreen<NoteViewModel>() {
    @Composable
    override fun Screen() {
        Scaffold() {
            Column(modifier = Modifier
                .padding(it)
                .background(red)
                .fillMaxSize()
            ) {

            }
        }
    }
}