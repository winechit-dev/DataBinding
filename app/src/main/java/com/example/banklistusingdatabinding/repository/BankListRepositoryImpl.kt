package com.example.banklistusingdatabinding.repository

import com.example.banklistusingdatabinding.repository.BankListRepository
import com.example.banklistusingdatabinding.response.BankListResponse
import com.example.banklistusingdatabinding.response.DataResponse
import com.example.banklistusingdatabinding.service.AppService
import io.reactivex.Observable


class BankListRepositoryImpl constructor(
 private val service : AppService
): BankListRepository {
    override fun getBankList(appId : String , secretKey : String): Observable<DataResponse<List<BankListResponse>>> {
        return service.getBankList(appId, secretKey)
    }

}