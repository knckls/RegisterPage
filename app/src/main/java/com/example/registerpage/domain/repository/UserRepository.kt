package com.example.registerpage.domain.repository

import com.example.registerpage.domain.models.UserData


interface UserRepository {

    fun saveName(userData: UserData): Long

    fun getName(): UserData
}