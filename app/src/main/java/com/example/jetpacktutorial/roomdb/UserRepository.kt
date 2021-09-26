package com.example.jetpacktutorial.roomdb

import com.example.jetpacktutorial.roomdb.db.UserDAO
import com.example.jetpacktutorial.roomdb.model.User

class UserRepository(private val userDAO: UserDAO) {

    val users = userDAO.getAllUser()

    suspend fun insert(user: User) : Long{
       return userDAO.insertUser(user)
    }

    suspend fun update(user: User) : Int{
       return userDAO.updateUser(user)
    }

    suspend fun delete(user: User) : Int{
       return userDAO.deleteUser(user)
    }

    suspend fun deleteAll() : Int{
       return userDAO.deleteAll()
    }
}