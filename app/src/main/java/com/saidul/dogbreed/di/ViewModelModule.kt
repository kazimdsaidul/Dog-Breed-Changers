package com.saidul.dogbreed.di


import com.saidul.dogbreed.ui.homePage.viewmodel.DogPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DogPageViewModel(get()) }

}