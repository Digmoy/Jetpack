package com.example.jetpacktutorial.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityNavOneBinding

class NavOneActivity : AppCompatActivity() {

//    private val binding : ActivityNavOneBinding by lazy {
//        DataBindingUtil.setContentView(this,R.layout.activity_nav_one)
//    }

    private lateinit var binding: ActivityNavOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_nav_one)
    }


}