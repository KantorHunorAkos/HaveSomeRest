package com.example.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.models.RegistrationUser

class RegistrationViewModel() : ViewModel(){
    private var user : MutableLiveData<RegistrationUser> = MutableLiveData<RegistrationUser>()

    fun getUser() : RegistrationUser? {
        return this.user.value
    }

    fun setUser(user : RegistrationUser){
        this.user.value = user
    }
}