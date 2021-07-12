package com.saidul.dogbreed_changers.data.network.exceptions

import java.io.IOException

class NoInternetException : IOException() {

    override val message: String?
        get() = "No Internet Connection"
}