package com.easylife.diary.feature.insight.components.streakView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.model.insights.WeekData
import java.time.format.TextStyle
import java.util.Locale

/**
 * Created by erenalpaslan on 22.01.2023
 */
@Composable
fun StreakItem(
    modifier: Modifier = Modifier,
    data: WeekData,
    today: Boolean = false
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .height(1.dp)
                    .background(gray)
            )
            Icon(
                imageVector = if (data.hasEntry) Icons.Rounded.Done else Icons.Rounded.Add,
                contentDescription = "Icon",
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(16.dp)
                    .background(if (data.hasEntry) red else gray)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .height(if (today) 0.dp else 1.dp)
                    .background(gray)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = data.date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
            style = MaterialTheme.typography.labelSmall
        )
    }
}