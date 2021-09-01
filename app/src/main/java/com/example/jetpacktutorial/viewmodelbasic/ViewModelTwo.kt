package com.example.jetpacktutorial.viewmodelbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelTwo(value : Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>

    get() = total

    init {
        total.value = value
    }

//    fun getTotal() : Int{
//        return total
//    }

    fun setTotal(input : Int){
        total.value = (total.value)?.plus(input)
    }
}