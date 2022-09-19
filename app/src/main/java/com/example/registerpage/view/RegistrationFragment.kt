package com.example.registerpage.view



import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.registerpage.MainActivity
import com.example.registerpage.R
import com.example.registerpage.databinding.FragmentRegistrationBinding
import com.example.registerpage.domain.usecase.SaveUserNameUseCase
import com.example.registerpage.presentation.RegistrationViewModel
import java.util.*

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val registrationViewModel: RegistrationViewModel by viewModels()
    private val registrationBinding: FragmentRegistrationBinding by viewBinding()
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository = userRepository) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initListeners(
            onFirstNameChanged = registrationViewModel::onFirstNameChanged,
            onLastNameChanged = registrationViewModel::onSecondNameChanged,
            onBdateChanged = registrationViewModel::onBirthdayChanged,
            onPasswordChanged = registrationViewModel::onPasswordChanged,
            onConfirmPasswordChanged = registrationViewModel::onConfirmPasswordChanged,
            onRegistrationButtonClick = {
                if (registrationViewModel.isFieldsValid()) {
                    val params = SaveUserNameUseCase()
                    val result: Boolean = userRepository.saveName(saveParam = params)
                    //startActivity(this, Intent(this, MainActivity::class.java))
                    //Todo Перейти на следующий экран и сохранить данные в базе данных
                } else {
                    //Todo Показать ошибки
                }
            }
        )
    }


    private fun initObserver() {
        registrationViewModel.registrationState.observe(viewLifecycleOwner) { userData ->

        }
    }

    private fun initListeners(
        onFirstNameChanged: (String) -> Unit,
        onLastNameChanged: (String) -> Unit,
        onBdateChanged: (Date) -> Unit,
        onPasswordChanged: (String) -> Unit,
        onConfirmPasswordChanged: (String) -> Unit,
        onRegistrationButtonClick: () -> Unit,
    ) = with(registrationBinding) {
        etFirstName.doAfterTextChanged { firstName ->
            onFirstNameChanged(firstName.toString())
        }
        etSecondName.doAfterTextChanged { lastName ->
            onLastNameChanged(lastName.toString())
        }
        etBirthday.doAfterTextChanged { etBDate ->
//            onBdateChanged(etBDate.toString())
        }
        etPassword.doAfterTextChanged { password ->
            onPasswordChanged(password.toString())
        }
        etConfirmPassword.doAfterTextChanged { copyPassword ->
            onConfirmPasswordChanged(copyPassword.toString())
        }

        btnSignUp.setOnClickListener {
            onRegistrationButtonClick()
        }
    }
}
