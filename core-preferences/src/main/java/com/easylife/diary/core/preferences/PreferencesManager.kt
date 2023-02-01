package com.easylife.diary.core.preferences

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Implementation of the data store
 */
class PreferencesManager(private val context: Context) {

    companion object {
        private val Context.dataStore by preferencesDataStore(
            name = PreferencesKeys.PREFERENCES_NAME
        )
    }

    suspend fun getBoolean(
        key: Preferences.Key<Boolean>,
        defaultValue: Boolean = true
    ): Boolean = context.dataStore.data.map {
        it[key] ?: defaultValue
    }.first()

    suspend fun setBoolean(key: Preferences.Key<Boolean>, value: Boolean) {
        context.dataStore.edit { it[key] = value }
    }

    suspend fun getInt(
        key: Preferences.Key<Int>,
        defaultValue: Int = -1
    ): Int = context.dataStore.data.map {
        it[key] ?: defaultValue
    }.first()

    suspend fun setInt(key: Preferences.Key<Int>, value: Int) {
        context.dataStore.edit { it[key] = value }
    }

    suspend fun getString(
        key: Preferences.Key<String>,
        defaultValue: String? = null
    ): String? = context.dataStore.data.map {
        it[key] ?: defaultValue
    }.first()

    suspend fun setString(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { it[key] = value }
    }
}