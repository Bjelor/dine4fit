package com.bjelor.dine4fit.domain.model

data class SearchResult(
    val id: String,
    val name: String,
    val thumbnailUrl: String,
    val energyPortion: String,
    val energyValue: String,
)