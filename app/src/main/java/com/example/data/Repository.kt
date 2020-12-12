package com.example.data

import com.example.api.RetrofitInstance
import retrofit2.Response

class Repository
{
    suspend fun getRestaurant255() : Response<Restaurant> = RetrofitInstance.api.getRestaurant255()

    suspend fun getRestaurantsInACity(city: String): Response<Restaurants> = RetrofitInstance.api.getRestaurantsInACity(city)

    suspend fun getAllRestaurants(per_page: Int):Response<Restaurants> = RetrofitInstance.api.getAllRestaurants(per_page)
}