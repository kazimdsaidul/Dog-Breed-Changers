package com.saidul.dogbreed_changers.di


import com.saidul.dogbreed_changers.data.network.AppAPIService
import com.saidul.dogbreed_changers.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { createRepository(get()) }
}

fun createRepository(movieAppAPIService: AppAPIService): Repository = Repository(movieAppAPIService)