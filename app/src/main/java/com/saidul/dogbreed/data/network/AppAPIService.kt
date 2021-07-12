package com.saidul.dogbreed.data.network

import com.saidul.dogbreed.data.model.BreedsItem
import com.saidul.dogbreed.data.model.ImagesResponseItem
import com.saidul.dogbreed.data.model.Result


class AppAPIService(private val api: Api) : BaseService() {

    suspend fun breeds(): Result<List<BreedsItem>> {
        return createCall { api.breeds() }
    }


    suspend fun images(limit: Int, page: Int, breed_id: Int): Result<List<ImagesResponseItem>> {
        return createCall { api.images(limit, page, breed_id) }
    }


}