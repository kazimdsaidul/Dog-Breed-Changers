package com.saidul.dogbreed.data.network.exceptions

import java.io.IOException


class UnAuthorizedException : IOException() {

    override val message: String?
        get() = "User Unauthorized"
}