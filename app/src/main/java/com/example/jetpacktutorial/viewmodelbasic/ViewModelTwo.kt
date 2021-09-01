package com.example.jetpacktutorial.viewmodelbasic

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelTwo(value : Int) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>

    get() = total

    @Bindable
    val inputText = MutableLiveData<String>()

    init {
        total.value = value
    }

//    fun getTotal() : Int{
//        return total
//    }

    fun setTotal(){
        val intInput : Int = inputText.value!!.toInt()
        total.value = (total.value)?.plus(intInput)
    }
}