package com.saidul.dogbreed.data.network


import com.saidul.dogbreed.data.model.BreedsItem
import com.saidul.dogbreed.data.model.ImagesResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/breeds")
    suspend fun breeds(): Response<List<BreedsItem>>


    @GET("v1/images/search?")
    suspend fun images(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("breed_id") breed_id: Int,
    ): Response<List<ImagesResponseItem>>

}