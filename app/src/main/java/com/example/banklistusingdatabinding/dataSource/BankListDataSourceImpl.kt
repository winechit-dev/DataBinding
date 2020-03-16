package com.example.banklistusingdatabinding.dataSource

import android.annotation.SuppressLint
import com.example.banklistusingdatabinding.repository.BankListRepositoryImpl
import com.example.banklistusingdatabinding.viewmodel.BankListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BankListDataSourceImpl constructor(
    private val repository: BankListRepositoryImpl,
    private val viewModel : BankListViewModel
) : BankListDataSource {
    @SuppressLint("CheckResult")
    override fun loadBankList() {
        repository.getBankList("2S2EOCol41Gc3U5oEVPs" , "Pw0Er4LDboezEPUAH44Z-KO32GuHeP3mrDHNEKtVT")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if(it!=null){
                    viewModel.setBankList(it.data!!)
                }
            },{
                viewModel.setError(it.localizedMessage)
            })
    }
}