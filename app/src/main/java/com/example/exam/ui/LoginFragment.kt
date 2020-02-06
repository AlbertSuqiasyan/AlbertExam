package com.example.exam.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.exam.LoginUserViewModel

import com.example.exam.R
import com.example.exam.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private val loginUserViewModel by viewModel<LoginUserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener { view: View ->
            val userName = binding.etUserName.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            loginUserViewModel.createUser(userName, password, view)
            loginUserViewModel.defaultResponse.observe(viewLifecycleOwner, Observer {

            })

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
        }



        return binding.root
    }




}
