package com.easylife.diary.feature.calendar

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.GetDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val dateUseCase: GetDateUseCase
): BaseViewModel() {

    fun onCurrentDateSelected() {
        viewModelScope.launch {
            dateUseCase.execute(Unit).collect()
        }
    }

}