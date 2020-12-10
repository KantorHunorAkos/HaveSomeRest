package com.example.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.Repository
import com.example.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application){
    /*val readAllData: LiveData<List<User>>
    private val repository: Repository

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository = Repository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }*/
}