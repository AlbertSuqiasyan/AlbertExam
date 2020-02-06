package com.example.exam.koin

import com.example.exam.LoginUserViewModel
import com.example.exam.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        LoginUserViewModel()
    }
    viewModel {
        MainViewModel()
    }
}