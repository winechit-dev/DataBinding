package com.example.banklistusingdatabinding.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.banklistusingdatabinding.response.BankListResponse


class BankListViewModel : ViewModel() {

    private val _banks = MutableLiveData<List<BankListResponse>>()
    val banks: LiveData<List<BankListResponse>>
        get() = _banks

    private val _error = MutableLiveData<String>()
    val error: MutableLiveData<String>
        get() = _error


    fun setBankList(list: List<BankListResponse>) {
        _banks.postValue(list)
    }

    fun setError(message: String) {
        _error.postValue(message)
    }

}