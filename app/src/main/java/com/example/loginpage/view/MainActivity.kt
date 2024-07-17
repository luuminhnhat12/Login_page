package com.example.loginpage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.loginpage.R
import com.example.loginpage.databinding.ActivityMainBinding
import com.example.loginpage.model.User
import com.example.loginpage.viewmodel.UserViewModel
import android.util.Log
class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Khởi tạo ViewModel đúng cách
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val textUsername = binding.username.text.toString()
        val textPassword = binding.password.text.toString()  // Tên biến binding.password viết thường chữ cái đầu

        val result = userViewModel.userViewModelCheck(textUsername, textPassword)  // Gọi hàm trực tiếp, không cần dấu gạch dưới
        print(User(textUsername,textPassword ).isValidPass())
        print(User(textUsername,textPassword ).isValidEmail())
        print(User(textUsername,textPassword ).getGmail().equals("nguoidep433@gmail.com"))
        println(User(textUsername,textPassword ).getPassword().equals("1234"))
        if (result) {
            Toast.makeText(v.context, "Login Successful!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(v.context, "Login Failed", Toast.LENGTH_LONG).show()
        }
    }
}
