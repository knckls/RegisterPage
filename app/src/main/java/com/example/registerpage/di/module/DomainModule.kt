package com.example.registerpage.di.module

import com.example.registerpage.domain.repository.UserRepository
import com.example.registerpage.domain.usecase.GetUserNameUseCase
import com.example.registerpage.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase =
        GetUserNameUseCase(userRepository)

    @Singleton
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase =
        SaveUserNameUseCase(userRepository)
}