package com.example.banklistusingdatabinding.inject

import androidx.databinding.library.BuildConfig
import com.example.banklistusingdatabinding.service.AppService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkServiceInject {
    private fun provideRetrofit(baseUrl : String) : Retrofit{
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(30 , TimeUnit.SECONDS)
        builder.readTimeout(30,TimeUnit.SECONDS)
        builder.writeTimeout(30,TimeUnit.SECONDS)
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

        if(BuildConfig.DEBUG){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.networkInterceptors().add(httpLoggingInterceptor)
        }
        val okHttpClient = builder.build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }
    fun provideService(baseUrl: String) : AppService {
        return provideRetrofit(baseUrl).create(AppService::class.java)
    }
}