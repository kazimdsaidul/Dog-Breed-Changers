package com.saidul.dogbreed.di


import com.saidul.dogbreed.data.network.AppAPIService
import com.saidul.dogbreed.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(movieAppAPIService: AppAPIService): Repository = Repository(movieAppAPIService)