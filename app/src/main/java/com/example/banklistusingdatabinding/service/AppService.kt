package com.example.banklistusingdatabinding.service

import androidx.databinding.library.BuildConfig
import com.example.banklistusingdatabinding.response.BankListResponse
import com.example.banklistusingdatabinding.response.DataResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

interface AppService {

    @GET("/api/banks?")
    fun getBankList(
        @Header("app-id") appId: String?,
        @Header("secret-key") secretKey: String?,
        @Header("Accept") headerType: String? = "application/json",
        @Header("app-version") appVersion: String? =  "android" + "-v" + BuildConfig.VERSION_NAME
    ): Observable<DataResponse<List<BankListResponse>>>
}