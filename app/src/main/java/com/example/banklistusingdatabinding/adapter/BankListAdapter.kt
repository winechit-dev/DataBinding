package com.example.banklistusingdatabinding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.banklistusingdatabinding.R
import com.example.banklistusingdatabinding.response.BankListResponse
import kotlinx.android.synthetic.main.bank_list_row.view.*

class BankListAdapter : RecyclerView.Adapter<BankListAdapter.ViewHolder>() {

    var dataList: List<BankListResponse> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.bank_list_row,
                parent,
                false
            )
        )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: BankListResponse) {
            Glide.with(itemView.imageView)
                    .load(data.logoUrl)
                    .apply(RequestOptions().error(R.drawable.ic_credit_card).placeholder(
                        R.drawable.ic_credit_card
                    ))
                    .into(itemView.imageView)

            itemView.name.text = data.name
        }
    }
}