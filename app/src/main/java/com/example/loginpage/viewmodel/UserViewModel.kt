package com.example.loginpage.viewmodel


import androidx.lifecycle.ViewModel
import com.example.loginpage.model.User

class UserViewModel :ViewModel() {
   fun userViewModelCheck(gmail:String,pass:String):Boolean{
        return User(gmail,pass).getGmail().equals("nguoidep433@gmail.com") && User(gmail,pass).getPassword().equals("1234")
   }

}