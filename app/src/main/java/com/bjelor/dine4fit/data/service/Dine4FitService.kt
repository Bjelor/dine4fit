package com.bjelor.dine4fit.data.service

import com.bjelor.dine4fit.data.model.DetailResponse
import com.bjelor.dine4fit.data.model.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Dine4FitService {

    @GET("/getSearchPotraviny.php")
    suspend fun getSearchPotraviny(
        @Query("Q") query: String
    ): SearchResultResponse

    @GET("/getPotravina.php")
    suspend fun getPotravina(
        @Query("GUID_Potravina") id: String
    ): DetailResponse
}