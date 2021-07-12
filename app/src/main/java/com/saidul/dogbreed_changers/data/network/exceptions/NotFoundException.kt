package com.saidul.dogbreed_changers.data.network.exceptions

import java.io.IOException

class NotFoundException : IOException() {

    override val message: String?
        get() = "Not Found"
}