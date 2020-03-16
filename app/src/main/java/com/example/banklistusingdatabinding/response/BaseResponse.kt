package com.example.banklistusingdatabinding.response

import com.google.gson.annotations.SerializedName

open class BaseResponse {

    @SerializedName("code")
    var responseCode: Int? = null

    @SerializedName("message")
    var message : String? = ""
}