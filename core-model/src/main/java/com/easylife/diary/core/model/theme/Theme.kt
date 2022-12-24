package com.easylife.diary.core.model.theme

/**
 * Created by erenalpaslan on 24.12.2022
 */
//TODO: Needs parent background color and
data class Theme(
    val id: Int,
    val name: String,
    val colorConfig: ColorConfig?,
    val fontConfig: FontConfig?,
    val backgroundImage: Int?,
    val smallBackgroundImage: Int?,
    val isPremium: Boolean,
    val isSelected: Boolean
)
