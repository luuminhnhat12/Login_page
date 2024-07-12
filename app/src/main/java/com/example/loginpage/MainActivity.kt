package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edtUsername :EditText
    lateinit var edtPassword :EditText
    lateinit var buttonLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtUsername = findViewById(R.id.username)
        edtPassword = findViewById(R.id.Password)

        buttonLogin = findViewById(R.id.loginButton)
        buttonLogin.setOnClickListener(this)



    }
    override fun onClick(v: View) {
        var textUsername = edtUsername.text.toString()
        var textPassword = edtPassword.text.toString()
        if(textUsername.equals("user") && textPassword.equals("1234")){
            Toast.makeText(v.context, "Login Successful!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(v.context, "Login Failed", Toast.LENGTH_LONG).show();
        }

    }

}