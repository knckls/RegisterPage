package com.example.registerpage.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registerpage.domain.models.UserData
import com.example.registerpage.domain.usecase.GetUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val _mainState = MutableStateFlow(initUserData())
    val mainState: StateFlow<MainUserData> = _mainState

    private fun initUserData() =
        MainUserData(
            firstName = "",
            secondName = ""
        )

    fun getUserData(userId: Int) = viewModelScope.launch {
        _mainState.value = getUserNameUseCase(userId).toUserDataUI()

    }

    private fun UserData.toUserDataUI(): MainUserData {
        return MainUserData(
            firstName = firstName,
            secondName = secondName
        )
    }
}

data class MainUserData(
    val firstName: String,
    val secondName: String
)