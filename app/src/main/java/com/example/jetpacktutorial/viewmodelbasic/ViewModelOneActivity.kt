package com.example.jetpacktutorial.viewmodelbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

/*        viewModel.count.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })*/


/*        binding.btnClick.setOnClickListener {
            viewModel.getUpdatedCount()
        }*/

    }
}