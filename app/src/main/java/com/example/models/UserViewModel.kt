package com.example.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application){
    val readAllUserData: LiveData<List<User>>
    private val userRepo: UserRepo
    val favorites: LiveData<List<Restaurant>>
    val favRepo: FavRepo

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        userRepo = UserRepo(userDao)
        readAllUserData = userRepo.readAllData

        val favDao = UserDatabase.getDatabase(application).favDao()
        favRepo = FavRepo(1,favDao)
        favorites = favRepo.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.addUser(user)
        }
    }
}