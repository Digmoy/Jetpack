package com.example.jetpacktutorial.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jetpacktutorial.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_two)

        //Main Thread if u want
        CoroutineScope(IO).launch {

            // sequential coroutine
/*            Log.i("MyTag","Calculation started...")
            val stockOne = getStockOne()
            val stockTwo = getStockTwo()

            val total = stockOne+stockTwo
            Log.i("MyTag","Total is $total")*/

            Log.i("MyTag","Calculation started...")
            val stockOne = async { getStockOne() }

            val stockTwo = async { getStockTwo() }

            val total = stockOne.await()+stockTwo.await()
            Log.i("MyTag","Total is $total")


          /*  Log.i("MyTag","Calculation started...")
            val stockOne = async(IO) { getStockOne() }

            val stockTwo = async(IO) { getStockTwo() }

            val total = stockOne.await()+stockTwo.await()
            Log.i("MyTag","Total is $total")*/
        }
    }

    private suspend fun getStockOne() : Int{
        delay(10000)
        Log.i("MyTag","Stock one return")
        return 55000
    }

    private suspend fun getStockTwo() : Int{
        delay(8000)
        Log.i("MyTag","Stock two return")
        return 35000
    }
}