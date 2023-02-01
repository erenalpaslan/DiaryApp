package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

/**
 * Created by erenalpaslan on 1.01.2023
 */
@Composable
fun BottomNavigationItem(
    selected: Boolean,
    icon: Int,
    selectedIcon: Int,
    label: String,
    onClick: () -> Unit
) {
    ConstraintLayout(modifier = Modifier) {
        val (iconRef, indicatorRef, labelRef) = createRefs()
        if (selected) {
            Box(
                modifier = Modifier
                    .constrainAs(indicatorRef) {
                        top.linkTo(iconRef.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(iconRef.bottom)
                        width = Dimension.value(40.dp)
                        height = Dimension.value(26.dp)
                    }
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
        IconButton(
            onClick = { onClick() },
            modifier = Modifier.constrainAs(iconRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Icon(
                painter = painterResource(
                    id = if (selected)
                        selectedIcon
                    else
                        icon
                ), contentDescription = "Tab Icon"
            )
        }
        Text(
            text = label,
            modifier = Modifier
                .constrainAs(labelRef) {
                    top.linkTo(iconRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = 5.dp),
        )
    }

}