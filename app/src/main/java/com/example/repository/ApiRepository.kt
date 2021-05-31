package com.example.repository

import com.example.api.RetrofitInstance
import com.example.models.CityRestaurants

class ApiRepository {

    suspend fun getCityRestaurants(city: String) : CityRestaurants{
        return RetrofitInstance.api.getCityRestaurants(city)
    }

    suspend fun getCityNames() : List<String>{
        val result = RetrofitInstance.api.getCityNames()

        return result.cities
    }
}