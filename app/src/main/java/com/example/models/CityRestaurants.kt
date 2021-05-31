package com.example.models

data class CityRestaurants(
    val total_entries : Int,
    val page : Int,
    val per_page : Int,
    val restaurants : List<Restaurant>
)