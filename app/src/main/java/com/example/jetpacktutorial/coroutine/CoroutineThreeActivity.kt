package com.example.jetpacktutorial.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpacktutorial.R

class CoroutineThreeActivity : AppCompatActivity() {

    private lateinit var viewModel : ViewModelOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_three)

        viewModel = ViewModelProvider(this)[ViewModelOne::class.java]
        viewModel.getUserData()

        viewModel.users.observe(this, Observer {myUsers ->
            myUsers.forEach{
                Log.i("MyTag","name is ${it.name}")
            }
        })
    }
}