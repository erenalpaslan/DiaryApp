package com.easylife.diary.core.preferences.di

import android.content.Context
import com.easylife.diary.core.preferences.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by erenalpaslan on 23.12.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun providePreferences(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

}