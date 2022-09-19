package com.example.registerpage.di.module

import com.example.registerpage.presentation.RegistrationViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class PresentationModule {

    @Singleton
    @Provides
    fun provideNewsViewModel(): RegistrationViewModel = RegistrationViewModel()
}