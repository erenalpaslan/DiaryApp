package com.easylife.diary.feature.splash

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.navigation.DiaryComposeNavigator
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import com.easylife.diary.core.preferences.PreferencesKeys
import com.easylife.diary.core.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 19.12.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager,
    private val navigator: DiaryNavigator
) : BaseViewModel() {

    private val shouldShowThemeSelection: Flow<Boolean> = flow {
        emit(preferencesManager.getBoolean(PreferencesKeys.IS_FIRST_ENTER))
    }

    init {
        viewModelScope.launch {
            shouldShowThemeSelection.map {
                if (it)
                    SplashUiState.NewComer
                else
                    SplashUiState.OnBoardedUser
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = SplashUiState.Loading
            ).collect {
                when (it) {
                    SplashUiState.Loading -> {}
                    SplashUiState.NewComer -> navigator.navigate(DiaryRoutes.themeRoute)
                    SplashUiState.OnBoardedUser -> navigator.navigate(DiaryRoutes.diaryRoute) {
                        popUpTo(DiaryRoutes.splashRoute) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            }
        }
    }

}