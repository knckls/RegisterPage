package com.example.registerpage.domain.repository

import com.example.registerpage.domain.models.UserData


interface UserRepository {

    suspend fun saveName(userData: UserData): Long

    suspend fun getName(userId: Int): UserData
}