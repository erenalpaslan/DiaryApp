package com.easylife.diary.core.designsystem.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

/**
 * Created by erenalpaslan on 8.01.2023
 */
enum class CustomDialogPosition {
    BOTTOM, TOP
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints);
    layout(constraints.maxWidth, constraints.maxHeight){
        when(pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height)
            }
            CustomDialogPosition.TOP -> {
                placeable.place(0,0)
            }
        }
    }
}