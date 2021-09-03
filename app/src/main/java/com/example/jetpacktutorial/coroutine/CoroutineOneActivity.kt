package com.example.jetpacktutorial.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityCoroutineOneBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Basic CoroutineScope example

class CoroutineOneActivity : AppCompatActivity() {

    private val binding : ActivityCoroutineOneBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_coroutine_one)
    }

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }

        binding.btnThread.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                showCurrentThread()
            }

        }
    }

    private fun showCurrentThread() {
        for (i in 1..200000)
        {
            Log.i("MyTag","ShowCurrentThread $i in ${Thread.currentThread().name}")
        }
    }
}