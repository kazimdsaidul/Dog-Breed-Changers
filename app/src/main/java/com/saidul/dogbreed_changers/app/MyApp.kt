package com.saidul.dogbreed_changers.app

import android.app.Application
import com.saidul.dogbreed_changers.di.networkModule
import com.saidul.dogbreed_changers.di.repositoryModule
import com.sundarban.pickndrop.di.viewModelModule


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