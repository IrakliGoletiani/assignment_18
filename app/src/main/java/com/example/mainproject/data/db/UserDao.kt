package com.example.mainproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT COUNT(email) FROM user WHERE email LIKE :email")
    suspend fun findByEmail(email: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}