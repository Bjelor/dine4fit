package com.bjelor.dine4fit.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bjelor.dine4fit.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    fun onSearchSubmit(query: String) {
        // TODO
        viewModelScope.launch {
            searchUseCase(query)
        }
    }

}