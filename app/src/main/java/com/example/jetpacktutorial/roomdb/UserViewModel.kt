package com.example.jetpacktutorial.roomdb

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacktutorial.roomdb.model.User
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class UserViewModel(private val repository: UserRepository) : ViewModel(), Observable {


    val users = repository.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete : User

    private val statusMassage = MutableLiveData<Event<String>>()

    val massage : LiveData<Event<String>>
    get() = statusMassage

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){

        if (inputName.value == null){
            statusMassage.value = Event("Please enter user's name")
        }
        else if (inputEmail.value == null)
        {
            statusMassage.value = Event("Please enter user's email address")
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches())
        {
            statusMassage.value = Event("Please enter valid email address")
        }
        else
        {
            if (isUpdateOrDelete) {
                userToUpdateOrDelete.name = inputName.value!!
                userToUpdateOrDelete.email = inputEmail.value!!

                update(userToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!

                insert(User(0, name, email))

                inputName.value = null
                inputEmail.value = null
            }
        }

    }

    fun clearAllOrDelete(){
        if (isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        } else {
            clearAll()
        }

    }

    fun insert(user : User) = viewModelScope.launch {
        val newRowId = repository.insert(user)

        if (newRowId > -1) {
            statusMassage.value = Event("User Inserted Successfully $newRowId")
        } else {
            statusMassage.value = Event("Error Occurred")
        }


    }

    fun update(user : User) = viewModelScope.launch {
        val noOfRow = repository.update(user)

        if (noOfRow > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false

            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMassage.value = Event("$noOfRow Updated Successfully")
        } else {
            statusMassage.value = Event("Error Occurred")
        }

    }

    fun delete (user: User) = viewModelScope.launch {
        val nowOfRowsDeleted = repository.delete(user)

        if (nowOfRowsDeleted > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false

            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMassage.value = Event("User Deleted Successfully $nowOfRowsDeleted")
        } else {
            statusMassage.value = Event("Error Occurred")
        }


    }
    fun clearAll() = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAll()
        if (noOfRowsDeleted > 0) {
            statusMassage.value = Event("$noOfRowsDeleted User Deleted Successfully")
        } else {
            statusMassage.value = Event("Error Occurred")
        }

    }

    fun initUpdateAndDelete(user: User){
        inputName.value = user.name
        inputEmail.value = user.email
        isUpdateOrDelete = true
        userToUpdateOrDelete = user

        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}