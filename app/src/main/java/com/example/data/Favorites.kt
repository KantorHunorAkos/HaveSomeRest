package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class Favorites (
    @PrimaryKey(autoGenerate = false)val id: Int,
    @ColumnInfo(name = "favorite_restaurants")val favRests: List<Restaurant>
)