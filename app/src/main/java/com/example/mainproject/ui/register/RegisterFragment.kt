package com.example.mainproject.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mainproject.R
import com.example.mainproject.data.db.User
import com.example.mainproject.util.Util.isEmailValid
import com.example.mainproject.util.Util.showSnackbar
import com.example.mainproject.databinding.FragmentRegisterBinding
import com.example.mainproject.extensions.hideKeyboard
import com.example.mainproject.util.Util
import com.example.mainproject.util.Util.areFieldsValid


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)

        setObserver()

        register()

        backPressed()

        return binding.root
    }

    private fun setObserver() {
        viewModel.isSuccessful.observe(viewLifecycleOwner, {
            if (it) {
                showSnackbar(binding.root, "User Registered")
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })

        viewModel.usersCount.observe(viewLifecycleOwner,{
            if (it == 0){
                viewModel.write(
                    User(
                        firstName = binding.etFirstName.text.toString(),
                        lastName = binding.etLastName.text.toString(),
                        email = binding.etEmail.text.toString(),
                        password = binding.etPassword.text.toString(),
                    )
                )
            } else {
                showSnackbar(binding.root, "User already registered")
            }
        })
    }

    private fun register() {
        binding.etFirstName.requestFocus()

        binding.btnSignUp.setOnClickListener {
            hideKeyboard()

            if (areFieldsValid(
                    editTexts = listOf(
                        binding.etFirstName,
                        binding.etLastName,
                        binding.etPassword,
                        binding.etEmail
                    )
                )
            ) {
                if (isEmailValid(binding.etEmail)) {
                    viewModel.checkEmail(binding.etEmail.text.toString())
                } else {
                    showSnackbar(binding.root, "Email isn't valid")
                }
            } else {
                showSnackbar(binding.root, "Please, fill all fields")
            }
        }
    }

    private fun backPressed() {
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            })
    }
}