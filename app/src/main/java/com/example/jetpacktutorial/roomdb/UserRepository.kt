package com.example.jetpacktutorial.roomdb

import com.example.jetpacktutorial.roomdb.db.UserDAO
import com.example.jetpacktutorial.roomdb.model.User

class UserRepository(private val userDAO: UserDAO) {

    val users = userDAO.getAllUser()

    suspend fun insert(user: User){
        userDAO.insertUser(user)
    }

    suspend fun update(user: User){
        userDAO.updateUser(user)
    }

    suspend fun delete(user: User){
        userDAO.deleteUser(user)
    }

    suspend fun deleteAll(){
        userDAO.deleteAll()
    }
}