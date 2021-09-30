package com.example.jetpacktutorial.dagger

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(val battery : Battery, val simcard: Simcard, val memorycard: Memorycard) {

    init {
        battery.getPower()
        simcard.getConnection()
        memorycard.getSpaceAvailability()
    }

    fun makeACall(){
        Log.i("MyTag","Calling...")
    }
}