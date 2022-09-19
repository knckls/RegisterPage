package com.example.registerpage.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(): ViewModel() {

    private val _registrationState = MutableLiveData(initUserData())
    val registrationState: LiveData<UserDataUI> = _registrationState

    fun onFirstNameChanged(firstName: String){
        _registrationState.value = _registrationState.value?.copy(firstName = firstName)
    }

    fun onSecondNameChanged(secondName: String){
        _registrationState.value = _registrationState.value?.copy(secondName = secondName)
    }

    fun onBirthdayChanged(birthday: Date){
        _registrationState.value = _registrationState.value?.copy(birthday = birthday)
    }

    fun onPasswordChanged(password: String){
        _registrationState.value = _registrationState.value?.copy(password = password)
    }

    fun onConfirmPasswordChanged(confirmPassword: String){
        _registrationState.value = _registrationState.value?.copy(confirmPassword = confirmPassword)
    }

    fun isFieldsValid() =
        !_registrationState.value?.firstName.isNullOrEmpty() && !_registrationState.value?.secondName.isNullOrEmpty()

    private fun initUserData() =
        UserDataUI(
            "",
            "",
            Date(),
            "",
            ""
        )
}