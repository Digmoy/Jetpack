package com.example.jetpacktutorial.twowaydatabinding

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelOne : ViewModel(),Observable{

    @Bindable
    val userName = MutableLiveData<String>()

    init {
        userName.value = "Digmoy"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}