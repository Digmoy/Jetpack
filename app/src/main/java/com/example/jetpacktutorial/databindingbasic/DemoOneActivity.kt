package com.example.jetpacktutorial.databindingbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityDemoOneBinding

class DemoOneActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDemoOneBinding

   // private lateinit var binding : ActivityDemoOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_demo_one)
        binding.btnSubmit.setOnClickListener {
            displayName()
        }
    }

    private fun displayName() {
        binding.userName.text = "Hello! "+binding.name.text

    }
}