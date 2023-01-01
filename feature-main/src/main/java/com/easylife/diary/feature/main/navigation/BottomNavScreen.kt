package com.easylife.diary.feature.main.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.TipsAndUpdates
import androidx.compose.ui.graphics.vector.ImageVector
import com.easylife.diary.feature.calendar.navigation.calendarRoute
import com.easylife.diary.feature.diary.navigation.diaryRoute
import com.easylife.diary.feature.insight.navigation.insightsRoute
import com.github.feature.setting.navigation.settingsRoute

/**
 * Created by erenalpaslan on 1.01.2023
 */
enum class BottomNavScreen(
    val route: String,
    val icon: ImageVector,
    val label: String
) {

    DIARY(
        diaryRoute,
        Icons.Rounded.Description,
        "Diary"
    ),
    CALENDAR(
        calendarRoute,
        Icons.Rounded.CalendarMonth,
        "Calendar"
    ),
    INSIGHTS(
        insightsRoute,
        Icons.Rounded.TipsAndUpdates,
        "Insights"
    ),
    SETTINGS(
        settingsRoute,
        Icons.Rounded.Settings,
        "Settings"
    );

    companion object {
        fun getScreens(): List<BottomNavScreen> = BottomNavScreen.values().toList()
    }


}