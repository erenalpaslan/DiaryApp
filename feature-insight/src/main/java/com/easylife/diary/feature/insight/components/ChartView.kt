package com.easylife.diary.feature.insight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.theme.red

/**
 * Created by erenalpaslan on 21.01.2023
 */
@Composable
fun ChartView(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Column(modifier = Modifier
            .size(100.dp)
            .background(red)) {

        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Text(text = "1")
            Text(text = "2")
            Text(text = "3")
            Text(text = "4")
            Text(text = "5")
            Text(text = "6")
            Text(text = "7")
        }
    }
}