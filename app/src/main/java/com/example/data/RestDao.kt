package com.example.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RestDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurant(restaurant: Restaurant)

    @Query("SELECT * FROM restaurant_table")
    fun readAllData() : LiveData<List<Restaurant>>
}