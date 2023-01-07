package com.easylife.diary.feature.main.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.diary.core.designsystem.theme.red

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