package com.easylife.diary.feature.insight.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.diary.core.designsystem.theme.red
import com.easylife.diary.core.model.insights.WeekData
import com.easylife.diary.feature.insight.R

/**
 * Created by erenalpaslan on 21.01.2023
 */
@Composable
fun DiaryStreakView(
    longestChain: Int = 14,
    streakData: List<WeekData> = emptyList(),
) {
    Card(
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .wrapContentSize()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val (titleRef, streakViewRef, dividerRef, chainRef) = createRefs()

            Text(
                text = "Diary streak",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            StreakView(
                modifier = Modifier.constrainAs(streakViewRef) {
                    top.linkTo(titleRef.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end, 24.dp)
                    width = Dimension.fillToConstraints
                },
                streakData = streakData
            )
            Divider(
                modifier = Modifier.constrainAs(dividerRef) {
                    top.linkTo(streakViewRef.bottom, 8.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                },
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(
                modifier = Modifier
                    .constrainAs(chainRef) {
                        top.linkTo(dividerRef.bottom, 8.dp)
                        start.linkTo(parent.start, 16.dp)
                        bottom.linkTo(parent.bottom, 16.dp)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fire),
                    contentDescription = "Fire Icon",
                    colorFilter = ColorFilter.tint(red),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Longest chain: ", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "$longestChain",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}