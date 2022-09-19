package com.example.registerpage.di

import com.example.registerpage.MainActivity
import com.example.registerpage.di.module.ContextModule
import com.example.registerpage.di.module.DataModule
import com.example.registerpage.di.module.DomainModule
import com.example.registerpage.di.module.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, PresentationModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}