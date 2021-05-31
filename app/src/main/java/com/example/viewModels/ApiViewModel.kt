package com.example.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.CityRestaurants
import com.example.repository.ApiRepository
import com.example.database.entities.EntityRestaurant
import kotlinx.coroutines.launch

class ApiViewModel(private val repository: ApiRepository): ViewModel() {
    val restaurants : MutableLiveData<List<EntityRestaurant>> = MutableLiveData()
    val cityNames : MutableLiveData<List<String>> = MutableLiveData()



    //get the restaurants of a city
    suspend fun getCityRestaurantsSuspend(city: String) {
        viewModelScope.launch {
            val apiResult = repository.getCityRestaurants(city)
            restaurants.value = CityRestaurantsToEntityRestaurants(apiResult)
        }
    }

    fun getCityRestaurants(city: String) {
        viewModelScope.launch {
            val apiResult = repository.getCityRestaurants(city)
            restaurants.value = CityRestaurantsToEntityRestaurants(apiResult)
        }
    }


    //Get city names and insert into the database
    private suspend fun getCityNames() {
        viewModelScope.launch {
            cityNames.value = repository.getCityNames()
        }

    }

    //Preload data what will be displayed
    //on the MainMenuFragment at startup
    fun LoadDataWithAPI(){
        viewModelScope.launch{
            getCityNames()
            getCityRestaurantsSuspend("Addison")
        }


    }

    // ********** PRIVATE FUNCTIONS **********
    fun CityRestaurantsToEntityRestaurants(apiResult: CityRestaurants) : List<EntityRestaurant>{
        val list = mutableListOf<EntityRestaurant>()

        for (i in 0 until apiResult.restaurants.size){
            val restaurant = apiResult.restaurants[i]
            val entityRestaurant = EntityRestaurant(
                0,
                restaurant.name,
                restaurant.address,
                restaurant.city,
                restaurant.state,
                restaurant.area,
                restaurant.postal_code,
                restaurant.country,
                restaurant.phone,
                restaurant.lat,
                restaurant.lng,
                restaurant.price,
                restaurant.reserve_url,
                restaurant.mobile_reserve_url,
                restaurant.mobile_reserve_url,
                ""
            )
            list.add(entityRestaurant)
        }
        return list
    }
}