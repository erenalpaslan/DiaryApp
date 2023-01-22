package com.easylife.diary.feature.insight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.model.insights.WeekData
import com.easylife.diary.feature.insight.components.streakView.StreakItem

/**
 * Created by erenalpaslan on 21.01.2023
 */
@Composable
fun StreakView(
    streakData: List<WeekData>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        streakData.forEachIndexed { index, data ->
            StreakItem(
                modifier = Modifier.fillMaxWidth().weight(1f),
                data = data,
                today = index == streakData.lastIndex
            )
        }
    }
}