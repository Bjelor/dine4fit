package com.bjelor.dine4fit.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bjelor.dine4fit.domain.model.SearchResult
import com.bjelor.dine4fit.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _searchResults: MutableStateFlow<List<SearchResult>?> = MutableStateFlow(null)
    val searchResult: StateFlow<List<SearchResult>?> = _searchResults.asStateFlow()

    fun onSearchSubmit(query: String) {
        viewModelScope.launch {
            _searchResults.value = searchUseCase(query)
        }
    }
}