package com.example.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRest(userId: Int,restaurant: Restaurant)

    @Query("SELECT favorite_restaurants FROM favorites_table")
    fun readAllData() : LiveData<List<Restaurant>>
}