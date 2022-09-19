package com.example.registerpage.presentation

data class UserDataUI(
    val firstName: String,
    val secondName: String,
    val birthday: String,
    val password: String,
    val confirmPassword: String,
    val validationResult: ValidationResult
)

sealed interface ValidationResult {
    object Succeed : ValidationResult
    data class Error(val errorText: String) : ValidationResult
    object Default : ValidationResult
}