package com.example.banklistusingdatabinding.di

import com.example.banklistusingdatabinding.repository.BankListRepositoryImpl
import com.example.banklistusingdatabinding.viewmodel.BankListViewModel
import com.example.banklistusingdatabinding.utils.NetworkUtils
import com.example.banklistusingdatabinding.dataSource.BankListDataSourceImpl
import com.example.banklistusingdatabinding.inject.NetworkServiceInject
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

val applicationModule = module (override = true){
    factory {
        CompositeDisposable()
    }
    single {
        NetworkServiceInject().provideService("https://dev.meemee.online/")
    }
    single {
        NetworkUtils.isOnline(get())
    }
}

val bankListModule = module {

    single {
        BankListRepositoryImpl(
            get()
        )
    }
    single {
        BankListViewModel()
    }
    single{
        BankListDataSourceImpl(
            get(),
            get()
        )
    }
}