package com.example.jetpacktutorial.twowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityTwoWayOneBinding

class TwoWayOneActivity : AppCompatActivity() {

    private val binding : ActivityTwoWayOneBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_two_way_one)
    }
    private lateinit var viewModel : ViewModelOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ViewModelOne::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

    }
}