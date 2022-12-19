package com.easylife.diary.utils.extensions

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt

/**
 * Created by erenalpaslan on 6.09.2022
 */
fun Offset.toIntOffset() = IntOffset(x.roundToInt(), y.roundToInt())
