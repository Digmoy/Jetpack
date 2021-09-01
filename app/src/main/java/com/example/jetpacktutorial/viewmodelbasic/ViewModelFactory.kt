package com.example.jetpacktutorial.viewmodelbasic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val value : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelTwo::class.java))
        {
            return ViewModelTwo(value) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}