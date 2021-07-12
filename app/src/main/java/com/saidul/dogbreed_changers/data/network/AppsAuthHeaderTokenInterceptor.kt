package com.saidul.dogbreed_changers.data.network

import com.saidul.dogbreed_changers.di.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AppsAuthHeaderTokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        request = request.newBuilder()
            .addHeader("x-api-key", Constants.API_KEY)
            .build()
        return chain.proceed(request)

    }

}
