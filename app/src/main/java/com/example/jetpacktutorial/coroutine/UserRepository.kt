package com.example.jetpacktutorial.coroutine

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers() : List<UserModel>{
        delay(8000)
        val users : List<UserModel> = listOf(
            UserModel(1,"Digmoy"),
            UserModel(2,"Alex"),
            UserModel(1,"Sam"),
            UserModel(1,"William")
        )

        return users
    }
}