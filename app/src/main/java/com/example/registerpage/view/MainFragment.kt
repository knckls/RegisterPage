package com.example.registerpage.view


import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.registerpage.R
import com.example.registerpage.databinding.FragmentMainBinding
import com.example.registerpage.databinding.FragmentRegistrationBinding
import com.example.registerpage.presentation.MainUserData
import com.example.registerpage.presentation.MainViewModel
import com.example.registerpage.presentation.RegistrationViewModel
import com.example.registerpage.presentation.ValidationResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.fragment_main) {

    private val mainViewModel: MainViewModel by viewModels()
    private val mainBinding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners(
            onHelloButtonClick = { mainViewModel.getUserData(1) }
        )
        initObserver()
    }


    private fun initObserver() {
        lifecycleScope.launch {
            mainViewModel.mainState
                .flowWithLifecycle(lifecycle)
                .collect {
                    if (it.firstName.isNotEmpty()) {
                        showName(it)
                    }
                }

        }
    }

    private fun showName(userData: MainUserData) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Ваше ФИ!")
            .setMessage("${userData.firstName} ${userData.secondName}")
            .setPositiveButton("ОК") { dialog, id ->
                dialog.cancel()
            }
        builder.create()
    }

    private fun initListeners(
        onHelloButtonClick: () -> Unit,
    ) {
        mainBinding.helloButton.setOnClickListener {
            onHelloButtonClick()
        }
    }
}
