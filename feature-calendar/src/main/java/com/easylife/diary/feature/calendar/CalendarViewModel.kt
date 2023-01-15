package com.easylife.diary.feature.calendar

import androidx.lifecycle.viewModelScope
import com.easylife.diary.core.common.util.DiaryResult
import com.easylife.diary.core.designsystem.base.BaseViewModel
import com.easylife.diary.core.domain.usecases.GetDatePointListByLocalDateUseCase
import com.easylife.diary.core.domain.usecases.GetDateUseCase
import com.easylife.diary.core.domain.usecases.GetEntryGroupByLocalDateUseCase
import com.easylife.diary.core.model.DiaryNote
import com.easylife.diary.core.model.EntryGroup
import com.easylife.diary.core.model.calendar.DatePoint
import com.easylife.diary.core.navigation.DiaryNavigator
import com.easylife.diary.core.navigation.screen.DiaryArgs
import com.easylife.diary.core.navigation.screen.DiaryRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

/**
 * Created by erenalpaslan on 1.01.2023
 */
@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val navigator: DiaryNavigator,
    private val getEntryGroupByLocalDateUseCase: GetEntryGroupByLocalDateUseCase
) : BaseViewModel() {

    private val _list: MutableStateFlow<List<EntryGroup>> = MutableStateFlow(emptyList())
    val list = _list.asStateFlow()

    var selectedDate: LocalDate? = null

    fun onSelectionChanged(localDate: LocalDate) {
        viewModelScope.launch {
            selectedDate = localDate
            getEntryGroupByLocalDateUseCase.execute(GetEntryGroupByLocalDateUseCase.Params(localDate)).collect {result ->
                when(result) {
                    is DiaryResult.Error -> _error.postValue(result.message)
                    is DiaryResult.Success -> {
                        result.data?.let { data ->
                            _list.update { data }
                        }

                    }
                }
            }
        }
    }

    fun navigateWithEntry(entry: DiaryNote) {
        navigator.navigate(
            route = "${DiaryRoutes.noteRoute}?${DiaryArgs.NOTE_KEY}=${navigator.toJson(entry)}"
        )
    }


}