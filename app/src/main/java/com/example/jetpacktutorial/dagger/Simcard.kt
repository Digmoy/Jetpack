package com.example.jetpacktutorial.dagger

import android.util.Log
import javax.inject.Inject

class Simcard @Inject constructor(private val serviceProvider: ServiceProvider) {

    init {
        Log.i("MyTag","Simcard Constructed")
    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}