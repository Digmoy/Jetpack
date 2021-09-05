package com.example.jetpacktutorial.databindingbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityDemoTwoBinding

class DemoTwoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDemoTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo_two)
            binding.user = getUser()
//        val user : UserModel = getUser()
//        binding.name.text = user.name
//        binding.email.text = user.email
    }

    private fun getUser(): UserModel {
        return UserModel(1,"Digmoy Saha","digmoyofficial@gmail.com")
    }
}