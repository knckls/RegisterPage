package com.example.registerpage.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.usecase.SaveUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _registrationState = MutableStateFlow(initUserData())
    val registrationState: StateFlow<UserDataUI> = _registrationState

    fun onFirstNameChanged(firstName: String) {
        _registrationState.value = _registrationState.value.copy(firstName = firstName)
    }

    fun onSecondNameChanged(secondName: String) {
        _registrationState.value = _registrationState.value.copy(secondName = secondName)
    }

    fun onBirthdayChanged(birthday: String) {
        _registrationState.value = _registrationState.value.copy(birthday = birthday)
    }

    fun onPasswordChanged(password: String) {
        _registrationState.value = _registrationState.value.copy(password = password)
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _registrationState.value = _registrationState.value.copy(confirmPassword = confirmPassword)
    }

    fun validateFields() {
        val someFieldIsEmpty = !_registrationState.value.firstName.isNullOrEmpty() &&
                !_registrationState.value.secondName.isNullOrEmpty() &&
                !_registrationState.value.birthday.isNullOrEmpty() &&
                !_registrationState.value.password.isNullOrEmpty() &&
                !_registrationState.value.confirmPassword.isNullOrEmpty()

        val passwordNotSame =
            _registrationState.value.password != _registrationState.value.confirmPassword

        _registrationState.value = _registrationState.value.copy(
            validationResult = when {
                !someFieldIsEmpty -> ValidationResult.Error("Какие-то поля не заполнены блин!")
                passwordNotSame -> ValidationResult.Error("Пароли не совпадают!")
                else -> {
                    saveUserName()
                    ValidationResult.Succeed
                }
            }
        )
    }

    private fun saveUserName() = viewModelScope.launch {
        saveUserNameUseCase(
            UserData(
                id = 1,
                firstName = _registrationState.value.firstName,
                secondName = _registrationState.value.secondName
            )
        )
    }


    private fun initUserData() =
        UserDataUI(
            "",
            "",
            "",
            "",
            "",
            validationResult = ValidationResult.Default
        )
}
