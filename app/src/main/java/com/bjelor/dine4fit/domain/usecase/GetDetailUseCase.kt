package com.bjelor.dine4fit.domain.usecase

import com.bjelor.dine4fit.data.model.DetailResponse
import com.bjelor.dine4fit.data.service.Dine4FitService
import com.bjelor.dine4fit.domain.model.Detail
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(private val service: Dine4FitService) {

    suspend operator fun invoke(id: String): Detail =
        service.getPotravina(id).toDomain()

    private fun DetailResponse.toDomain(): Detail = Detail(
        id = guid,
        name = name,
        photoUrl = photoUrl,
        energy = values.energy.format(),
        protein = values.protein.format(),
        carbs = values.carbs.format(),
        fat = values.fat.format(),
    )

    private fun DetailResponse.NutritionalValue.format(): String =
        String.format("%.0f", value) + " " + unit
}