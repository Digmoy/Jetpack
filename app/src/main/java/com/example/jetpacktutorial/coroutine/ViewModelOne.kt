package com.example.jetpacktutorial.coroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModelOne : ViewModel() {

    private var userRepository = UserRepository()
   // var users : MutableLiveData<List<UserModel>?> = MutableLiveData()
    /*fun getUserData(){

        viewModelScope.launch {
            var result : List<UserModel>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result
        }
    }*/

    var users = liveData(Dispatchers.IO) {
        val result = UserRepository().getUsers()
        emit(result)
    }


}