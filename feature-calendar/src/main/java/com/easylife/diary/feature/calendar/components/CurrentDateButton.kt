package com.easylife.diary.feature.calendar.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easylife.diary.core.common.util.DateUtil

/**
 * Created by erenalpaslan on 12.01.2023
 */
@Composable
fun CurrentDateButton(
    isCurrentMonth: Boolean,
    onClick: () -> Unit
) {
    if (!isCurrentMonth) {
        IconButton(
            onClick = {
                onClick()
            },
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Rounded.CalendarToday,
                    contentDescription = "Calendar Icon"
                )
                Text(
                    text = DateUtil.getCurrentDayOfMonth(),
                    modifier = Modifier.padding(top = 6.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}
