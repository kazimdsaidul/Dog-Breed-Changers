package com.saidul.dogbreed_changers.di


import com.saidul.dogbreed_changers.ui.homePage.viewmodel.DogPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DogPageViewModel(get()) }

}