package com.example.api

import com.example.models.CityNames
import com.example.models.CityRestaurants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("restaurants")
    suspend fun getCityRestaurants(@Query("city") city: String) : CityRestaurants

    @GET("cities")
    suspend fun getCityNames() : CityNames
}