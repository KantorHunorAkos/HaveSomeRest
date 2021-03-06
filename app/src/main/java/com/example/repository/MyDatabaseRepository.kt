package com.example.repository

import androidx.lifecycle.LiveData
import com.example.database.daos.MyDatabaseDao
import com.example.database.entities.*
import java.text.SimpleDateFormat

class MyDatabaseRepository(private val myDatabaseDao : MyDatabaseDao) {

    val readAllData : LiveData<List<EntityUser>> = myDatabaseDao.readAllData()

    suspend fun addUser(entityUser : EntityUser){
        myDatabaseDao.addUser(entityUser)
    }

    suspend fun getUser(email : String, passwordHash: String) : EntityUser?{
        return myDatabaseDao.getUser(email,passwordHash)
    }

    //Converting restaurants returned by api (CityRestaurants) to EntityRestaurant
    //what will be added to the database with a TIMESTAMP using suspend function
    suspend fun addRestaurants(restaurants : List<EntityRestaurant>){
        for (i in 0 until restaurants.size){

            //get timestamp
            val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
            val formattedDate = formatter.format(parser.parse("2021-05-27T09:55:00"))

            restaurants[i].timestamp = formattedDate

            myDatabaseDao.InsertRestaurant(restaurants[i])
        }
    }

    // Insert a list of cities to the database
    suspend fun addCities(cities : List<String>){
        for (i in 0 until cities.size){
            val city = EntityCity(0,cities[i])
            myDatabaseDao.InsertCity(city)
        }
    }

    //Get the count of restaurants of a given city and page,
    //available in the database

    suspend fun getCount(city : String) : Int{
        return myDatabaseDao.getCount(city)
    }

    //Query the restaurants with the
    //given city name and page
    suspend fun getRestaurants(city : String, page: Int) : List<EntityRestaurant>{
        return myDatabaseDao.getRestaurants(city)
    }

    suspend fun deleteCache(){
        myDatabaseDao.deleteRestaurants()
        myDatabaseDao.deleteUsers()
    }

    //get the list of city names
    suspend fun getCityNames() : List<String>{
        return myDatabaseDao.getCityNames()
    }

    //get user id
    suspend fun getUserId(email : String) : Int{
        return myDatabaseDao.getUserId(email)
    }

    //add favorite to the database
    suspend fun addFavorite(favorite: EntityFavorite){
        myDatabaseDao.addFavorite(favorite)
    }

    //delete favorite from database
    suspend fun deleteFavorite(userId: Int, restaurantId: Int){
        myDatabaseDao.deleteFavorite(userId, restaurantId)
    }

    //check if the restaurant is liked
    suspend fun isLiked(userId: Int, restaurantId: Int) : Boolean{
        return myDatabaseDao.isLiked(userId, restaurantId) != 0
    }

    //get favorite restaurants of a user
    suspend fun getFavorites(userId: Int) : MutableList<EntityFavorite>?{
        return myDatabaseDao.getFavorites(userId)
    }

    //add profile image to database
    suspend fun addProfileImage(image : EntityProfilePicture){
        myDatabaseDao.addProfileImage(image)
    }

    //delete profile image
    suspend fun deleteProfileImage(userId: Int){
        myDatabaseDao.deleteProfileImage(userId)
    }

    //check if the user has a profile image
    suspend fun profileImageIsExists(userId: Int) : Boolean{
        return myDatabaseDao.profileImageIsExists(userId) > 0
    }

    //get the profile image of the user as byteArray
    suspend fun getProfileImage(userId: Int): EntityProfilePicture{
        return myDatabaseDao.getProfileImage(userId)
    }

    suspend fun addRestaurantPicture(image : EntityRestaurantPicture){
        myDatabaseDao.addRestaurantImage(image)
    }

    suspend fun getRestaurantPictureCount(restaurantId: Int) : Int{
        return myDatabaseDao.getRestaurantPictureCount(restaurantId)
    }

    suspend fun getOneRestaurantPicture(restaurantId: Int) : EntityRestaurantPicture{
        return myDatabaseDao.getOneRestaurantPicture(restaurantId)
    }

    suspend fun getAllRestaurantPicture(restaurantId: Int) : MutableList<EntityRestaurantPicture>{
        return myDatabaseDao.getAllRestaurantPicture(restaurantId)
    }

    suspend fun deleteRestaurantPicture(pictureId : Int){
        myDatabaseDao.deleteRestaurantPicture(pictureId)
    }

    fun getAPictureId() : Int{
        return myDatabaseDao.getAPictureId()
    }
}