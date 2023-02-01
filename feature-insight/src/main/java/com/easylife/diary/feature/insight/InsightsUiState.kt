package com.easylife.diary.feature.insight

import com.easylife.diary.core.model.insights.WeekData

/**
 * Created by erenalpaslan on 22.01.2023
 */
data class InsightsUiState(
    val streakData: List<WeekData> = emptyList(),
    val longestChain: Int = 0
)
