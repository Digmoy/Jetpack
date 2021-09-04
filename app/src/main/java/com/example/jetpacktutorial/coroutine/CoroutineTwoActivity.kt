package com.example.jetpacktutorial.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.jetpacktutorial.R
import com.example.jetpacktutorial.databinding.ActivityCoroutineTwoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineTwoActivity : AppCompatActivity() {

    private val binding : ActivityCoroutineTwoBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_coroutine_two)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        binding.btnUnstructured.setOnClickListener {
            CoroutineScope(Main).launch {
                binding.tvUnstructured.text = UserUnStructured().getTotalUserCount().toString()
            }
        }

        binding.btnStructured.setOnClickListener {
            CoroutineScope(Main).launch {
                binding.tvStructured.text = UserStructure().getTotalUserCount().toString()
            }
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