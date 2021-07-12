package com.saidul.dogbreed_changers.ui.homePage.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.saidul.dogbreed_changers.base.BaseViewModel
import com.saidul.dogbreed_changers.data.model.BreedsItem
import com.saidul.dogbreed_changers.data.model.ImagesResponseItem
import com.saidul.dogbreed_changers.data.repository.Repository
import com.saidul.dogbreed_changers.ui.homePage.paged.ImagePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


class DogPageViewModel(private val repository: Repository) : BaseViewModel() {

    var imagePagingSource: ImagePagingSource? = null
    var imageData: Flow<PagingData<ImageModel>> = getInstantDeliveryDataStream()
        .map { pagingData -> pagingData.map { ImageModel.ImageItem(it) } }


    val mBreeds: MutableLiveData<List<BreedsItem>> by lazy {
        MutableLiveData<List<BreedsItem>>()
    }

    val mBreedsItem: MutableLiveData<BreedsItem> by lazy {
        MutableLiveData<BreedsItem>()
    }

    val showMessageToUser: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    private val pageSize = 10

    fun getInstantDeliveryDataStream(): Flow<PagingData<ImagesResponseItem>> {

        return Pager(PagingConfig(10)) {
            imagePagingSource = ImagePagingSource(repository, mBreedsItem.value)
            imagePagingSource!!
        }.flow.cachedIn(viewModelScope)
    }


    fun breeds() {
        processBarUILiveData.value = true
        viewModelScope.launch {
            try {
                val breeds = repository.breeds()
                processBarUILiveData.value = false
                val size = breeds.size
                if (size == 0) {
                    showMessageToUser.value = "No bog breeds found"
                } else {
                    mBreeds.value = breeds
                }

            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    fun onItemClick(get: BreedsItem?) {

        mBreedsItem.value = get
    }


}

sealed class ImageModel {
    data class ImageItem(val dataItem: ImagesResponseItem) : ImageModel()
}



