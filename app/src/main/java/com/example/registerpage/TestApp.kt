package com.example.registerpage

import android.app.Application
import com.example.registerpage.di.AppComponent
import com.example.registerpage.di.DaggerAppComponent
import com.example.registerpage.di.module.ContextModule

class TestApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().contextModule(ContextModule(this.applicationContext))
            .build()
    }
}