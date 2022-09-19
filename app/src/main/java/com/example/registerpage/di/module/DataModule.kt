package com.example.registerpage.di.module

import android.content.Context
import androidx.room.Room
import com.example.registerpage.data.UserRepositoryImpl
import com.example.registerpage.data.database.UserDao
import com.example.registerpage.data.database.UserDataBase
import com.example.registerpage.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)

    @Singleton
    @Provides
    fun provideUserDao(context: Context): UserDao =
        Room.databaseBuilder(
            context.applicationContext,
            UserDataBase::class.java,
            "user_db.db"
        ).build().getUserDao()
}