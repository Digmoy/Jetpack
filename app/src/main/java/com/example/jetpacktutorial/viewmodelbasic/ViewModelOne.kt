package com.example.jetpacktutorial.viewmodelbasic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelOne : ViewModel() {

    var count = MutableLiveData<Int>()

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