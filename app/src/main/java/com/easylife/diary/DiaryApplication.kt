package com.easylife.diary

import android.app.Application
import com.easylife.diary.common.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by erenalpaslan on 19.12.2022
 */
class DiaryApplication: Application() {

    private val modules = listOf(
        appModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DiaryApplication)
            modules(modules)
        }
    }
}