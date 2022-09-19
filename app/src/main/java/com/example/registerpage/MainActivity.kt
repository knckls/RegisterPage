package com.example.registerpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registerpage.TestApp.Companion.component

class MainActivity : AppCompatActivity() {

    //Todo Чтобы снавигироваться на след экран,
    // нужно после сохранения данных пользователя сохранить Long (Id) в sharedPreference и проверять,
    // нулл он или нет при каждом открытии приложения. Если не null, то открывать след экран.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        component.injectMainActivity(this)
    }
}