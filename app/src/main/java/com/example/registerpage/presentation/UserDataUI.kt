package com.example.registerpage.presentation

import java.util.*

data class UserDataUI(
    val firstName: String,
    val secondName: String,
    val birthday: Date,
    val password: String,
    val confirmPassword: String
)