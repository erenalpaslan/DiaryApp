package com.easylife.diary.feature.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.easylife.diary.core.designsystem.base.BaseScreen
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 1.01.2023
 */
class CalendarScreen : BaseScreen<CalendarViewModel>(){
    @Composable
    override fun Screen() {
        Scaffold() {
            Column(modifier = Modifier.padding(it).background(red)) {

            }
        }
    }
}