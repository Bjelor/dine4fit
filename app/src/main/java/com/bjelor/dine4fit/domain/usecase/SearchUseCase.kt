package com.bjelor.dine4fit.domain.usecase

import com.bjelor.dine4fit.data.service.Dine4FitService
import com.bjelor.dine4fit.data.model.SearchResultResponse
import com.bjelor.dine4fit.domain.model.SearchResult
import javax.inject.Inject

class SearchUseCase @Inject constructor(private val service: Dine4FitService) {

    suspend operator fun invoke(query: String): List<SearchResult> =
        service.getSearchPotraviny(query).toDomain()

    private fun SearchResultResponse.toDomain(): List<SearchResult> =
        items.map { item ->
            SearchResult(
                id = item.guid,
                name = item.name,
                thumbnailUrl = item.thumbnailUrl,
                energyPortion = item.energy.portion,
                energyValue = item.energy.value.formatTwoDecimals() + " " + energyUnit,
            )
        }

    private fun Double.formatTwoDecimals(): String = String.format("%.0f", this)

}