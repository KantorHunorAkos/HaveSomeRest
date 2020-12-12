package com.example.api

import com.example.data.Restaurant
import com.example.data.Restaurants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {
    @GET("restaurants/255")
    suspend fun getRestaurant255(): Response<Restaurant>

    @GET("restaurants")
    suspend fun getRestaurantsInACity(
        @Query("city") city: String
    ): Response<Restaurants>

    @GET("restaurants")
    suspend fun getAllRestaurants(
        @Query("per_page")per_page:Int
    ) : Response<Restaurants>
}