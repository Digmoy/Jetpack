package com.example.jetpacktutorial.dagger

import android.util.Log
import javax.inject.Inject

class Memorycard @Inject constructor() {

    init {
        Log.i("MyTag","Memorycard Constructed")
    }

    fun getSpaceAvailability(){
        Log.i("MyTag","Memory space available")
    }
}