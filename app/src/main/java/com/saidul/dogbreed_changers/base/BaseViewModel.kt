package com.saidul.dogbreed_changers.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saidul.dogbreed_changers.data.network.exceptions.NoInternetException


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 5/11/21.
 */
open class BaseViewModel : ViewModel() {
    val processBarUILiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val noInternetUILiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val mShowErrorMessageToUser: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun handleException(e: Exception) {
        processBarUILiveData.value = false
        when (e) {
            is NoInternetException -> {
                noInternetUILiveData.value = true
            }
            else -> {
                mShowErrorMessageToUser.value = e.message
            }
        }
    }
}