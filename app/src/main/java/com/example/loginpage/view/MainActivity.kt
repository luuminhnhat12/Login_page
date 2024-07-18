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
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.loginButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val textUsername = binding.username.text.toString()
        val textPassword = binding.password.text.toString()
        val result = userViewModel.userViewModelCheck(textUsername, textPassword)

        if (result) {
            Toast.makeText(v.context, "Login Successful!", Toast.LENGTH_LONG).show()

            // Cập nhật trạng thái người dùng
            userViewModel.updateState(User(textUsername, textPassword))

            // Quan sát stateUser sau khi cập nhật
            userViewModel.stateUser.observe(this, Observer { newuser ->
                // Kiểm tra và hiển thị Toast dựa trên trạng thái
                val message = if (newuser.getGmail().isNotEmpty()) "Updated state" else "Failed"
                Toast.makeText(v.context, message, Toast.LENGTH_LONG).show()
            })
        }else {
            Toast.makeText(v.context, "Login Failed", Toast.LENGTH_LONG).show()
        }
    }
}
