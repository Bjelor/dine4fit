package com.bjelor.dine4fit.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bjelor.dine4fit.domain.model.Detail
import com.bjelor.dine4fit.domain.usecase.GetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase,
) : ViewModel() {

    private val _detail: MutableStateFlow<Detail?> = MutableStateFlow(null)
    val detail: StateFlow<Detail?> = _detail.asStateFlow()

    fun onNewArguments(id: String) {
        viewModelScope.launch {
            _detail.value = getDetailUseCase(id)
        }
    }
}