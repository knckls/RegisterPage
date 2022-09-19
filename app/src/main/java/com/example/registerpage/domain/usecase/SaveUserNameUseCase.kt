package com.example.registerpage.domain.usecase

import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    //Todo не сохранять, если пользователем с таким именем уже был

    fun execute(param: UserData) : Boolean {
        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}