package com.example.registerpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.registerpage.TestApp.Companion.component
import com.example.registerpage.data.UserRepositoryImpl
import com.example.registerpage.domain.usecase.GetUserNameUseCase



class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {UserRepositoryImpl(context = applicationContext)}
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {GetUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        component.injectMainActivity(this)

        val helloTextView = findViewById<TextView>(R.id.helloText)
        val receiveButton = findViewById<Button>(R.id.helloButton)

        // Как записать visibility?

        receiveButton.setOnClickListener {
            val userName: UserName = userRepository.getName()
            helloTextView.text = ""
        }
    }

}