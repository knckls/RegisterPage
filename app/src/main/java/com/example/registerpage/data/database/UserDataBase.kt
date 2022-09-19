package com.example.registerpage.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.registerpage.domain.models.UserData

@Database(
    entities = [UserData::class],
    version = 1,
    exportSchema = false
)
abstract class UserDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}