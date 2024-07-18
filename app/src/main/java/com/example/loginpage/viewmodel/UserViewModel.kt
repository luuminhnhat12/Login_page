package com.example.loginpage.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginpage.model.User

class UserViewModel :ViewModel() {
    private val _stateUser = MutableLiveData<User>()
    val stateUser: LiveData<User> get() = _stateUser

    fun updateState(newUser: User) {
        _stateUser.value = newUser
    }
   fun userViewModelCheck(gmail:String,pass:String):Boolean{

        return User(gmail,pass).getGmail().equals("nguoidep433@gmail.com") && User(gmail,pass).getPassword().equals("1234")
   }

}