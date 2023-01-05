package com.easylife.diary.core.navigation

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by erenalpaslan on 4.01.2023
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideDiaryComposeNavigator(
        diaryComposeNavigator: DiaryComposeNavigator
    ): DiaryNavigator

}