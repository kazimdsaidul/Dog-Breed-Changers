package com.sundarban.pickndrop.di


import com.saidul.dogbreed_changers.ui.DogPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DogPageViewModel(get()) }

}