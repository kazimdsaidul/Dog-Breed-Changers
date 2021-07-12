package com.saidul.dogbreed.app

import android.app.Application
import com.saidul.dogbreed.di.networkModule
import com.saidul.dogbreed.di.repositoryModule
import com.saidul.dogbreed.di.viewModelModule


import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }


}