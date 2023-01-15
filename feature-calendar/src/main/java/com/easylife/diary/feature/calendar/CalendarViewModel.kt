package com.easylife.diary.feature.calendar

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.GetDateUseCase
import com.easylife.diary.core.model.calendar.DatePoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class CalendarViewModel @Inject constructor() : BaseViewModel() {

    fun onSelectionChanged(point: DatePoint) {

    }

}