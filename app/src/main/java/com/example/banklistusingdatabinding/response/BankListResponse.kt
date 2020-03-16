package com.example.banklistusingdatabinding.response

import com.google.gson.annotations.SerializedName

data class BankListResponse (
    @SerializedName("updated_at")
    var updatedAt: String? = "",
    @SerializedName("logo_url")
    var logoUrl: String = "",
    @SerializedName("is_major")
    var isMajor: Boolean = false,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("created_at")
    var createdAt: String = "",
    @SerializedName("id")
    var id: Int = 0,
    var isSelected : Boolean = false
)