package com.example.jetpacktutorial.databindingbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.viewmodelbasic.ViewModelOneActivity
import com.example.jetpacktutorial.databinding.ActivityDataBindingBinding
import com.example.jetpacktutorial.twowaydatabinding.TwoWayOneActivity
import com.example.jetpacktutorial.viewmodelbasic.ViewModelTwoActivity

class DataBindingActivity : AppCompatActivity() {

    private val binding : ActivityDataBindingBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnOne.setOnClickListener {
            val intent = Intent(this, DemoOneActivity::class.java)
            startActivity(intent)
        }

        binding.btnTwo.setOnClickListener {
            val intent = Intent(this, DemoTwoActivity::class.java)
            startActivity(intent)
        }

        binding.btnThree.setOnClickListener {
            val intent = Intent(this, ViewModelOneActivity::class.java)
            startActivity(intent)
        }

        binding.btnFour.setOnClickListener {
            val intent = Intent(this, ViewModelTwoActivity::class.java)
            startActivity(intent)
        }

        binding.btnFive.setOnClickListener {
            val intent = Intent(this, TwoWayOneActivity::class.java)
            startActivity(intent)
        }

    }
}