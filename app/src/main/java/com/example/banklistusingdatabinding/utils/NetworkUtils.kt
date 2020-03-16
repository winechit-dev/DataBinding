package com.example.banklistusingdatabinding.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo



object NetworkUtils {


    fun isOnline(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var netInfo: NetworkInfo? = null
        if (cm != null) {
            netInfo = cm.activeNetworkInfo
        }
        return netInfo!= null && netInfo.isConnected
    }
}