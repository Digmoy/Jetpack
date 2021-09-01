package com.example.jetpacktutorial.ViewModelBasic

import androidx.lifecycle.ViewModel

class ViewModelOne : ViewModel() {

    private var count = 0

    fun getCurrentCount() : Int{
        return count
    }

    fun getUpdatedCount() : Int{
        return ++count
    }
}