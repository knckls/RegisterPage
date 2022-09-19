package com.example.registerpage.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.registerpage.R
import com.example.registerpage.databinding.FragmentRegistrationBinding
import com.example.registerpage.presentation.RegistrationViewModel
import com.example.registerpage.presentation.ValidationResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val registrationViewModel: RegistrationViewModel by viewModels()
    private val registrationBinding: FragmentRegistrationBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Тут проверять. Если не нулл, то findNavController().navigate(
        //                            R.id.action_registrationFragment_to_mainFragment
        //                        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners(
            onFirstNameChanged = registrationViewModel::onFirstNameChanged,
            onLastNameChanged = registrationViewModel::onSecondNameChanged,
            onBdateChanged = registrationViewModel::onBirthdayChanged,
            onPasswordChanged = registrationViewModel::onPasswordChanged,
            onConfirmPasswordChanged = registrationViewModel::onConfirmPasswordChanged,
            onRegistrationButtonClick = {
                registrationViewModel.validateFields()
            }
        )
        initObserver()
    }


    private fun initObserver() {
        lifecycleScope.launch {
            registrationViewModel.registrationState
                .flowWithLifecycle(lifecycle)
                .collect{
                    if (it.validationResult is ValidationResult.Succeed) {
                        findNavController().navigate(
                            R.id.action_registrationFragment_to_mainFragment
                        )
                    } else if (it.validationResult is ValidationResult.Error) {
                        showError(it.validationResult.errorText)
                    }
                }
        }
    }

    private fun showError(errorText: String) {
        view?.let {
            Snackbar.make(it, errorText, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    private fun initListeners(
        onFirstNameChanged: (String) -> Unit,
        onLastNameChanged: (String) -> Unit,
        onBdateChanged: (String) -> Unit,
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
            onBdateChanged(etBDate.toString())
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
