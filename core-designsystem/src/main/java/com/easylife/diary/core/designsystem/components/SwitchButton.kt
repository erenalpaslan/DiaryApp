package com.easylife.diary.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

/**
 * Created by erenalpaslan on 6.01.2023
 */
@Composable
fun SwitchButton(
    title: String,
    description: String?,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        val (titleRef, descriptionRef, switchRef) = createRefs()

        Text(
            text = title,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(switchRef.start, 8.dp)
                width = Dimension.fillToConstraints
            })
        if (!description.isNullOrEmpty()) {
            Text(
                text = description ?: "",
                modifier = Modifier.constrainAs(descriptionRef) {
                    top.linkTo(titleRef.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(switchRef.start, 8.dp)
                    width = Dimension.fillToConstraints
                }.alpha(0.5f)
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = {
                onCheckedChange(it)
            },
            modifier = Modifier.constrainAs(switchRef) {
                top.linkTo(titleRef.top)
                bottom.linkTo(descriptionRef.bottom)
                end.linkTo(parent.end)
            }
        )
    }
}