package com.example.models

import android.util.Log
import androidx.lifecycle.*
import com.example.data.Repository
import com.example.data.Restaurant
import com.example.data.Restaurants
import com.example.fragments.MyItemRecyclerViewAdapter
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Restaurant>> = MutableLiveData()
    val mRestaurantsInACity: MutableLiveData<Response<Restaurants>> = MutableLiveData()
    val mAllRestaurants: MutableLiveData<Response<Restaurants>> = MutableLiveData()

    fun getRestaurant255() {
        viewModelScope.launch {
            val response = repository.getRestaurant255()
            myResponse.value = response
        }
    }

    fun getRestaurantsInACity(city: String) {
        viewModelScope.launch {
            val response = repository.getRestaurantsInACity(city)
            mRestaurantsInACity.value = response
        }
    }

    fun getAllRestaurants(per_page:Int) {
        viewModelScope.launch {
            val response = repository.getAllRestaurants(per_page )
            mAllRestaurants.value = response
        }
    }
}