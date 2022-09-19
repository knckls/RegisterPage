package com.example.registerpage.di

import com.example.registerpage.MainActivity
import com.example.registerpage.di.module.ContextModule
import com.example.registerpage.di.module.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class,PresentationModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}