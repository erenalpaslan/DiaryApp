package com.easylife.diary.feature.insight.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

/**
 * Created by erenalpaslan on 21.01.2023
 */
@Composable
fun MoodGraph() {
    Card(
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .wrapContentSize()
    ) {
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            val (titleRef, lineGraphRef) = createRefs()
            Text(
                text = "Trends",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            LineGraph(modifier = Modifier.constrainAs(lineGraphRef) {
                top.linkTo(titleRef.bottom, 16.dp)
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
                bottom.linkTo(parent.bottom, 8.dp)
                width = Dimension.fillToConstraints
            })
        }
    }
}