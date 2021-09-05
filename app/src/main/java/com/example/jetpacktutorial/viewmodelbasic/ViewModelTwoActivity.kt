package com.example.jetpacktutorial.viewmodelbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityViewModelTwoBinding

class ViewModelTwoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewModelTwoBinding

    private lateinit var viewModel : ViewModelTwo
    private lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_view_model_two)
        factory = ViewModelFactory(1)
        viewModel = ViewModelProvider(this,factory)[ViewModelTwo::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this


       /* viewModel.totalData.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })*/


       /* binding.btnClick.setOnClickListener {
            Log.e("shgfskdhlkg","ksghklshdk")
            viewModel.setTotal(binding.edInput.text.toString().toInt())
        }*/

    }
}