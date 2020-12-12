package com.example.data

import androidx.lifecycle.LiveData

class FavRepo (
    val userId: Int,
    val favDao: FavDao
) {
    val readAllData: LiveData<List<Restaurant>> = favDao.readAllData()

    suspend fun addRest(restaurant: Restaurant){
        favDao.addRest(userId,restaurant)
    }
}