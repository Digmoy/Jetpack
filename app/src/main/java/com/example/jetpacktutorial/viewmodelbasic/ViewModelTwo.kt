package com.example.jetpacktutorial.viewmodelbasic

import androidx.lifecycle.ViewModel

class ViewModelTwo(value : Int) : ViewModel() {
    private var total = 0

    init {
        total = value
    }

    fun getTotal() : Int{
        return total
    }

    fun setTotal(input : Int){
        total += input
    }
}