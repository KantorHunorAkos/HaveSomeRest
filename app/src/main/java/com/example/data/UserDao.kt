package com.example.data

import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.http.Path

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table")
    fun readAllData() : LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)
}