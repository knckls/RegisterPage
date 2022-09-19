package com.example.registerpage.domain.usecase

import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(private val userRepository: UserRepository) {

    operator suspend fun invoke(userId: Int): UserData {
        return userRepository.getName(userId)
    }
}