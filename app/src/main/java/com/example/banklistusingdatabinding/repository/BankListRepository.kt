package com.example.banklistusingdatabinding.repository

import com.example.banklistusingdatabinding.response.BankListResponse
import com.example.banklistusingdatabinding.response.DataResponse
import io.reactivex.Observable

interface BankListRepository {
    fun getBankList(appId : String , secretKey : String) : Observable<DataResponse<List<BankListResponse>>>
}