package com.example.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.data.Restaurant
import com.example.data.Restaurants
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

    fun getAllRestaurants(per_page:Int = 1411) {
        viewModelScope.launch {
            val response = repository.getAllRestaurants(per_page )
            mAllRestaurants.value = response
        }
    }
}