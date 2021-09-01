package com.example.jetpacktutorial.viewmodelbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelOne : ViewModel() {

    private var count = MutableLiveData<Int>()
    val countData : LiveData<Int>

    get() = count

    init {
        count.value = 0
    }

//    fun getCurrentCount() : Int{
//        return count
//    }

    fun getUpdatedCount(){
        count.value = (count.value)?.plus(1)
    }
}