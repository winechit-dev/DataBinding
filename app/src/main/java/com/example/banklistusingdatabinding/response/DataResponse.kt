package com.example.banklistusingdatabinding.response

import com.google.gson.annotations.SerializedName

class DataResponse<T> : BaseResponse(){
    @SerializedName("data")
    var data : T? = null
}