package com.example.banklistusingdatabinding.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banklistusingdatabinding.viewmodel.BankListViewModel
import com.example.banklistusingdatabinding.R
import com.example.banklistusingdatabinding.adapter.BankListAdapter
import com.example.banklistusingdatabinding.dataSource.BankListDataSourceImpl
import com.example.banklistusingdatabinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<BankListViewModel>()
    private val dataSourceImpl : BankListDataSourceImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        val adapter =
            BankListAdapter()
        rvBankList.setHasFixedSize(true)
        rvBankList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvBankList.adapter = adapter
        if(viewModel.banks.value == null){
            dataSourceImpl.loadBankList()
        }


    }
}
