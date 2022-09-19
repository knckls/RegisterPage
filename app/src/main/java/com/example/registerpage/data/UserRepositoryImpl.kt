package com.example.registerpage.data


import com.example.registerpage.data.database.UserDao
import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.repository.UserRepository

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override suspend fun saveName(userData: UserData): Long {
        return userDao.upsert(userData)
    }

    override suspend fun getName(userId: Int): UserData {
        return userDao.getUserData(userId)
    }
}