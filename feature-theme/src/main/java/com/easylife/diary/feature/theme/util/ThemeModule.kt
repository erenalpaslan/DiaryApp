package com.easylife.diary.feature.theme.util

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by erenalpaslan on 26.12.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object ThemeModule {

    @Provides
    @Singleton
    fun provideThemeObservable(): ThemeObservable {
        return ThemeObservable()
    }

}