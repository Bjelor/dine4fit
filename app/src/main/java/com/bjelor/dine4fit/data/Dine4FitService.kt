package com.bjelor.dine4fit.data

import retrofit2.http.GET
import retrofit2.http.Query

interface Dine4FitService {

    @GET("/getSearchPotraviny.php/")
    suspend fun getSearchPotraviny(
        @Query("Q") query: String
    ): String

    @GET("/getSearchPotraviny.php/")
    suspend fun getPotravina(
        @Query("GUID_Potravina") query: String
    ): String
}