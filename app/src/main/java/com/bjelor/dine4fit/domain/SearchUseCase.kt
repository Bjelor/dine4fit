package com.bjelor.dine4fit.domain

import com.bjelor.dine4fit.data.Dine4FitService
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val service: Dine4FitService) {

    suspend operator fun invoke(query: String): String = service.getSearchPotraviny(query)
}