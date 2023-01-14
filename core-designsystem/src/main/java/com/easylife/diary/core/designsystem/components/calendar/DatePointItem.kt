package com.easylife.diary.core.designsystem.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.easylife.diary.core.designsystem.theme.black
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.designsystem.theme.green
import com.easylife.diary.core.designsystem.theme.white
import com.easylife.diary.core.model.calendar.DatePoint

/**
 * Created by erenalpaslan on 14.01.2023
 */
@Composable
fun DatePointItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    point: DatePoint,
    onClick: (DatePoint) -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .defaultMinSize(minWidth = 20.dp, minHeight = 36.dp)
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(if (selected) green else if (point.isCurrentDate) green.copy(0.25f) else Color.Transparent)
            .border(
                1.dp,
                if (point.isCurrentDate) green else Color.Transparent,
                RoundedCornerShape(4.dp)
            )
            .clickable {
                onClick(point)
            }
    ) {
        val (textRef, dotRef) = createRefs()
        Text(
            text = point.date.dayOfMonth.toString(),
            color = if (selected) white else if (point.active) black else gray,
            modifier = Modifier.constrainAs(textRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Box(
            modifier = Modifier
                .constrainAs(dotRef) {
                    bottom.linkTo(parent.bottom, 2.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(6.dp)
                .clip(CircleShape)
                .background(if (point.hasEntry) if (selected) white else green else Color.Transparent)
        )
    }
}
