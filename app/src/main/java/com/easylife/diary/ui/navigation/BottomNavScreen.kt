package com.easylife.diary.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.TipsAndUpdates
import androidx.compose.ui.graphics.vector.ImageVector
import com.easylife.diary.R
import com.easylife.diary.core.navigation.screen.DiaryRoutes.calendarRoute
import com.easylife.diary.core.navigation.screen.DiaryRoutes.diaryRoute
import com.easylife.diary.core.navigation.screen.DiaryRoutes.insightsRoute
import com.easylife.diary.core.navigation.screen.DiaryRoutes.settingsRoute

/**
 * Created by erenalpaslan on 5.01.2023
 */
enum class BottomNavScreen(
    val route: String,
    val icon: Int,
    val selectedIcon: Int,
    val label: String
) {
    DIARY(
        diaryRoute,
        R.drawable.ic_diary,
        R.drawable.ic_fill_diary,
        "Diary"
    ),
    CALENDAR(
        calendarRoute,
        R.drawable.ic_calendar,
        R.drawable.ic_fill_calendar,
        "Calendar"
    ),
    INSIGHTS(
        insightsRoute,
        R.drawable.ic_insights,
        R.drawable.ic_fill_insights,
        "Insights"
    ),
    SETTINGS(
        settingsRoute,
        R.drawable.ic_settings,
        R.drawable.ic_fill_settings,
        "Settings"
    );

    companion object {
        fun getScreens(): List<BottomNavScreen> = BottomNavScreen.values().toList()
    }
}