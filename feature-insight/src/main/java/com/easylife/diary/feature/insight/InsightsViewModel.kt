package com.easylife.diary.feature.insight

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.GetWeekDataUseCase
import com.easylife.diary.core.preferences.PreferencesKeys
import com.easylife.diary.core.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class InsightsViewModel @Inject constructor(
    private val getWeekDataUseCase: GetWeekDataUseCase,
    private val preferencesManager: PreferencesManager
): BaseViewModel() {

    private val _uiState: MutableStateFlow<InsightsUiState> = MutableStateFlow(InsightsUiState())
    val uiState: StateFlow<InsightsUiState> = _uiState.asStateFlow()

    init {
        getWeekData()
    }

    fun getWeekData() = viewModelScope.launch {
        getWeekDataUseCase.execute(Unit).collect {result ->
            when(result) {
                is DiaryResult.Error -> _error.postValue(result.message)
                is DiaryResult.Success -> _uiState.update {
                    it.copy(
                        streakData = result.data ?: emptyList(),
                        longestChain = preferencesManager.getInt(PreferencesKeys.LONGEST_CHAIN, 0)
                    )
                }
            }
        }
    }

}