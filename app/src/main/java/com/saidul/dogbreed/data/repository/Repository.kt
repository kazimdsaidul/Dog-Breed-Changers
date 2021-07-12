package com.saidul.dogbreed.data.repository

import com.saidul.dogbreed.data.model.BreedsItem
import com.saidul.dogbreed.data.model.ImagesResponseItem
import com.saidul.dogbreed.data.model.Result
import com.saidul.dogbreed.data.network.AppAPIService

class Repository(private val APIService: AppAPIService) {

    suspend fun breeds(): List<BreedsItem> {
        return when (val result = APIService.breeds()) {
            is Result.Success -> result.data
            is Result.Error -> throw result.error
        }
    }

    suspend fun images(limit: Int, page: Int, breed_id: Int): List<ImagesResponseItem> {
        return when (val result = APIService.images(limit, page, breed_id)) {
            is Result.Success -> result.data
            is Result.Error -> throw result.error
        }
    }


}