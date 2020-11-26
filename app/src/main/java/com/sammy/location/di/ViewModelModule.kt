package com.sammy.location.di

import com.sammy.location.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainActivityViewModel(
            locationsBaseUseCase = get(named("location"))
        )
    }
}