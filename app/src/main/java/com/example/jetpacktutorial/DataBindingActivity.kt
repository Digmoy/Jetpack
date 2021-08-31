package com.example.jetpacktutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private val binding : ActivityDataBindingBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnOne.setOnClickListener {
            val intent = Intent(this,DemoOneActivity::class.java)
            startActivity(intent)
        }

        binding.btnTwo.setOnClickListener {
            val intent = Intent(this,DemoTwoActivity::class.java)
            startActivity(intent)
        }

    }
}