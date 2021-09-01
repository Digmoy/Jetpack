package com.example.jetpacktutorial.ViewModelBasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityViewModelOneBinding

class ViewModelOneActivity : AppCompatActivity() {

    private val binding : ActivityViewModelOneBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_view_model_one)
    }

    private lateinit var viewModel : ViewModelOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModelOne::class.java]

        binding.tvCount.text = viewModel.getCurrentCount().toString()

        binding.btnClick.setOnClickListener {
            binding.tvCount.text = viewModel.getUpdatedCount().toString()
        }
    }
}