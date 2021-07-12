package com.saidul.dogbreed_changers.di

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.saidul.dogbreed_changers.BuildConfig
import com.saidul.dogbreed_changers.data.network.Api
import com.saidul.dogbreed_changers.data.network.AppAPIService
import com.saidul.dogbreed_changers.data.network.AppsAuthHeaderTokenInterceptor

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { okhttpClient() }
    single { retrofit(get()) }
    single { apiService(get()) }
    single { createMovieAppService(get()) }
}

fun createMovieAppService(
    api: Api
): AppAPIService = AppAPIService(api)

fun apiService(
    retrofit: Retrofit
): Api =
    retrofit.create(Api::class.java)

fun retrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(Constants.KEY_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun okhttpClient(): OkHttpClient {

    val builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        builder.addInterceptor(OkHttpProfilerInterceptor())

    }
    builder.addInterceptor(AppsAuthHeaderTokenInterceptor())

    builder.connectTimeout(APIConstant.KEY_TIME_LIMIT, TimeUnit.SECONDS)
    builder.writeTimeout(APIConstant.KEY_TIME_LIMIT, TimeUnit.SECONDS)
    builder.readTimeout(APIConstant.KEY_TIME_LIMIT, TimeUnit.SECONDS)

    val client = builder.build()
    return client;
}