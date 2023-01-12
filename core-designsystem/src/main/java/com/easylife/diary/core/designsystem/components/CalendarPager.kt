package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by erenalpaslan on 12.01.2023
 */
@Composable
fun CalendarPager() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Sun", style = MaterialTheme.typography.labelSmall)
        Text(text = "Mon", style = MaterialTheme.typography.labelSmall)
        Text(text = "Tue", style = MaterialTheme.typography.labelSmall)
        Text(text = "Wed", style = MaterialTheme.typography.labelSmall)
        Text(text = "Thu", style = MaterialTheme.typography.labelSmall)
        Text(text = "Fri", style = MaterialTheme.typography.labelSmall)
        Text(text = "Sat", style = MaterialTheme.typography.labelSmall)
    }
}