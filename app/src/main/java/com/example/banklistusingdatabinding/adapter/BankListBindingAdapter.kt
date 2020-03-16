package com.example.banklistusingdatabinding.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.banklistusingdatabinding.adapter.BankListAdapter
import com.example.banklistusingdatabinding.response.BankListResponse

@BindingAdapter("setList")
 fun setList(recyclerView: RecyclerView, list : List<BankListResponse>?) {
    if (list == null) return
    if(recyclerView.adapter is BankListAdapter){
        (recyclerView.adapter as BankListAdapter).dataList = list
    }

}