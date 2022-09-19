package com.example.registerpage.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.registerpage.domain.models.UserData

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(userData: UserData): Long

    @Query("SELECT * FROM user WHERE id = :userId")
    suspend fun getUserData(userId: Int): UserData
}