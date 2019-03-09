package com.ayo.data.db.dao

import androidx.room.*
import com.ayo.data.db.model.UserData

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getUsers(): List<UserData>

    @Query("SELECT * FROM users WHERE id =:id")
    suspend fun getUser(id: Long?): List<UserData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserData): Long

}