package com.example.jetpacktutorial.roomdb.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jetpacktutorial.roomdb.model.User

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user : User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM user_data_table")
    fun getAllUser() : LiveData<List<User>>
}