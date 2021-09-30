package com.example.jetpacktutorial.dagger

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){

    init {
        Log.i("MyTag","Service provider Constructed")
    }

    fun getServiceProvider(){
        Log.i("MyTag","Service provider connected")
    }
}