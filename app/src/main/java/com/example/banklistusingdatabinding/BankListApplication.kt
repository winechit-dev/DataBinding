package com.example.banklistusingdatabinding

import android.app.Application
import com.example.banklistusingdatabinding.di.applicationModule
import com.example.banklistusingdatabinding.di.bankListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class BankListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidFileProperties()
            modules(
                listOf(
                    applicationModule,
                    bankListModule
                )
            )
        }
    }
}