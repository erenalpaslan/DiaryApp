package com.easylife.diary.feature.onboarding

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.model.theme.Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by erenalpaslan on 19.12.2022
 */
class ThemeViewModel: BaseViewModel() {

    private val _uiState: MutableStateFlow<ThemeUiState> = MutableStateFlow(ThemeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update {
                ThemeUiState.Success(listOf(
                    Theme(
                        id = 1,
                        name = "Sarı Kız",
                        colorConfig = null,
                        fontConfig = null,
                        backgroundImage = null,
                        smallBackgroundImage = null,
                        isPremium = false,
                        isSelected = false
                    ),
                    Theme(
                        id = 2,
                        name = "Pembe",
                        colorConfig = null,
                        fontConfig = null,
                        backgroundImage = null,
                        smallBackgroundImage = null,
                        isPremium = false,
                        isSelected = false
                    ),
                    Theme(
                        id = 1,
                        name = "Karacaoğlan",
                        colorConfig = null,
                        fontConfig = null,
                        backgroundImage = null,
                        smallBackgroundImage = null,
                        isPremium = false,
                        isSelected = false
                    ),
                ))
            }
        }
    }

}