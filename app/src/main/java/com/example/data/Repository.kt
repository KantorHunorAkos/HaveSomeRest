package com.example.data

import com.example.api.RetrofitInstance
import retrofit2.Response

class Repository
//    (private val userDao: UserDao)
{
//    val readAllData: LiveData<List<User>> = userDao.readAllData()
//
//    suspend fun addUser(user: User){
//        userDao.addUser(user)
//    }

    suspend fun getRestaurant255() : Response<Restaurant> = RetrofitInstance.api.getRestaurant255()

    suspend fun getRestaurantsInACity(city: String): Response<Restaurants> = RetrofitInstance.api.getRestaurantsInACity(city)

    suspend fun getAllRestaurants(per_page: Int):Response<Restaurants> = RetrofitInstance.api.getAllRestaurants(per_page)
}