package com.easylife.diary.common

import com.easylife.diary.utils.dispatchers.DiaryDispatchers
import com.easylife.diary.utils.preferences.PreferencesManager
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by erenalpaslan on 19.12.2022
 */
val appModule = module {
    factory { PreferencesManager(androidContext()) }
    single { DiaryDispatchers() }
    factory { Gson() }
}