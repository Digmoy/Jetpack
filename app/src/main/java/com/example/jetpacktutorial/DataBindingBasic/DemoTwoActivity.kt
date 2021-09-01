package com.example.jetpacktutorial.DataBindingBasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityDemoTwoBinding

class DemoTwoActivity : AppCompatActivity() {

    private val binding : ActivityDemoTwoBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_demo_two)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding.user = getUser()
//        val user : UserModel = getUser()
//        binding.name.text = user.name
//        binding.email.text = user.email
    }

    private fun getUser(): UserModel {
        return UserModel(1,"Digmoy Saha","digmoyofficial@gmail.com")
    }
}