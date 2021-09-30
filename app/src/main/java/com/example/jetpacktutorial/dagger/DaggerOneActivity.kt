package com.example.jetpacktutorial.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jetpacktutorial.R

class DaggerOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_one)

      /*  val battery = Battery()
        val memorycard = Memorycard()
        val serviceProvider = ServiceProvider()
        val simcard = Simcard(serviceProvider)

        val smartPhone = SmartPhone(battery, simcard, memorycard)

        smartPhone.makeACall()*/

        DaggerSmartPhoneComponent.create().getSmartPhone().makeACall()
    }
}