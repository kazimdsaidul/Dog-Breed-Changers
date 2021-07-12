package com.saidul.dogbreed_changers.data.network.exceptions

import java.io.IOException


class UnAuthorizedException : IOException() {

    override val message: String?
        get() = "User Unauthorized"
}