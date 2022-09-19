package com.example.registerpage.data


import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.repository.UserRepository


class UserRepositoryImpl(): UserRepository {
    override fun saveName(userData: UserData): Long {
        TODO("Not yet implemented")
    }

    override fun getName(): UserData {
        TODO("Not yet implemented")
    }

}