package com.example.loginpage.model

import java.util.regex.Pattern

class User(private var gmail: String, private var password: String) {

    // Hàm khởi tạo
    init {
        this.gmail = gmail
        this.password = password
    }

    // Getter cho gmail
    fun getGmail(): String {
        return this.gmail
    }

    // Getter cho password
    fun getPassword(): String {
        return this.password
    }

    // Setter cho gmail
    fun setGmail(newGmail: String) {
        this.gmail = newGmail
    }

    // Setter cho password
    fun setPassword(newPassword: String) {
        this.password = newPassword
    }
    fun isValidEmail():Boolean{
        return this.gmail.isNotEmpty() && Pattern.compile(this.gmail).matcher(gmail).matches();
    }

    fun isValidPass():Boolean{
        return this.password.isNotEmpty() && this.password.length >=6;
    }

}
