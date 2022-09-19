package com.example.registerpage.di.module

import com.example.registerpage.domain.usecase.GetUserNameUseCase
import com.example.registerpage.domain.usecase.SaveUserNameUseCase
import com.example.registerpage.presentation.MainViewModel
import com.example.registerpage.presentation.RegistrationViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

    @Singleton
    @Provides
    fun provideRegistrationViewModel(useCase: SaveUserNameUseCase): RegistrationViewModel = RegistrationViewModel(useCase)

    @Singleton
    @Provides
    fun provideMainViewModel(useCase: GetUserNameUseCase): MainViewModel = MainViewModel(useCase)
}