package com.example.jetpacktutorial.databindingbasic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.coroutine.CoroutineOneActivity
import com.example.jetpacktutorial.coroutine.CoroutineThreeActivity
import com.example.jetpacktutorial.coroutine.CoroutineTwoActivity
import com.example.jetpacktutorial.viewmodelbasic.ViewModelOneActivity
import com.example.jetpacktutorial.databinding.ActivityDataBindingBinding
import com.example.jetpacktutorial.navigationcomponent.NavOneActivity
import com.example.jetpacktutorial.roomdb.RoomOneActivity
import com.example.jetpacktutorial.twowaydatabinding.TwoWayOneActivity
import com.example.jetpacktutorial.viewmodelbasic.ViewModelTwoActivity

class DataBindingActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

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

        binding.btnSix.setOnClickListener {
            val intent = Intent(this, NavOneActivity::class.java)
            startActivity(intent)
        }

        binding.btnSeven.setOnClickListener {
            val intent = Intent(this, CoroutineOneActivity::class.java)
            startActivity(intent)
        }

        binding.btnEight.setOnClickListener {
            val intent = Intent(this, CoroutineTwoActivity::class.java)
            startActivity(intent)
        }

        binding.btnNine.setOnClickListener {
            val intent = Intent(this, CoroutineThreeActivity::class.java)
            startActivity(intent)
        }

        binding.btnTen.setOnClickListener {
            val intent = Intent(this, RoomOneActivity::class.java)
            startActivity(intent)
        }

    }
}