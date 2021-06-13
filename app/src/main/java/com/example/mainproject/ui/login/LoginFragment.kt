package com.example.mainproject.ui.login

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mainproject.R
import com.example.mainproject.databinding.FragmentLoginBinding
import com.example.mainproject.extensions.hideKeyboard
import com.example.mainproject.util.Util.areFieldsValid
import com.example.mainproject.util.Util.isEmailValid
import com.example.mainproject.util.Util.showSnackbar


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        observer()

        init()

        return binding.root
    }

    private fun observer() {
        viewModel.usersCount.observe(viewLifecycleOwner, {
            if (it == 0) {
                showSnackbar(binding.root, "User not registered")
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_launchFragment)
                showSnackbar(binding.root, "Successful")

            }
        })
    }

    private fun init() {
        binding.tvSignUp.paintFlags = binding.tvSignUp.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        binding.tvSignUp.setOnClickListener {
            hideKeyboard()

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnSignIn.setOnClickListener {
            hideKeyboard()

            if (areFieldsValid(listOf(binding.etEmail, binding.etPassword))) {
                if (isEmailValid(binding.etEmail)) {
                    viewModel.checkEmail(binding.etEmail.text.toString())

                } else {
                    showSnackbar(binding.root, "Email is not valid")
                }
            } else {
                showSnackbar(binding.root, "Please, fill all fields")
            }
        }
    }

}
