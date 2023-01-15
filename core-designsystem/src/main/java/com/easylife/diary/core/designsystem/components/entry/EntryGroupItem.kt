package com.easylife.diary.core.designsystem.components.entry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.diary.core.designsystem.theme.gray
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup

/**
 * Created by erenalpaslan on 11.01.2023
 */
@Composable
fun EntryGroupItem(
    item: EntryGroup,
    onItemClicked: (DiaryNote) -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (groupInfoRef, dividerRef, entryRef) = createRefs()
            Column(
                modifier = Modifier.constrainAs(groupInfoRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, 16.dp)
                    height = Dimension.wrapContent
                },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = item.dayOfMonth ?: "",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(text = item.month ?: "", style = MaterialTheme.typography.bodyLarge)
                Text(text = item.year.toString(), style = MaterialTheme.typography.bodyLarge)
            }
            Box(
                modifier = Modifier
                    .constrainAs(dividerRef) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(groupInfoRef.end, 8.dp)
                        width = Dimension.value(4.dp)
                        height = Dimension.fillToConstraints
                    }
                    .clip(CircleShape)
                    .background(gray)
            )
            Column(
                modifier = Modifier.constrainAs(entryRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, 8.dp)
                    start.linkTo(dividerRef.end, 8.dp)
                    width = Dimension.fillToConstraints
                }
            ) {
                item.list.forEachIndexed { index, entry ->
                    DiaryListItem(entry) {
                        onItemClicked(entry)
                    }
                    if (item.list.lastIndex != index) {
                        Divider(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, end = 8.dp))
                    }
                }
            }
        }
        Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
    }
}