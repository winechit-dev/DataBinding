package com.example.banklistusingdatabinding.response

import com.google.gson.annotations.SerializedName

class ListDataResponse<T> : BaseResponse() {
    @SerializedName("data")
    var data :List<T>?  = null
}