package com.easylife.diary.core.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    const val PREFERENCES_NAME = "DIARY_PREFERENCES"
    val IS_FIRST_ENTER = booleanPreferencesKey("IS_FIRST_ENTER")
    val SELECTED_THEME_ID = intPreferencesKey("SELECTED_THEME_ID")
    val LAST_ENTRY_DATE = stringPreferencesKey("LAST_ENTRY_DATE")
    val LONGEST_CHAIN = intPreferencesKey("LONGEST_CHAIN")
    val LAST_CHAIN = intPreferencesKey("LAST_CHAIN")
}