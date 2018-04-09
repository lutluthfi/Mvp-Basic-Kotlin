package com.example.lutluthfi.mvpbasickotlin.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object NetworkUtils {

    private lateinit var activeNetwork: NetworkInfo

    fun isNetworkConnected(context: Context?) : Boolean {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        activeNetwork = cm.activeNetworkInfo
        return activeNetwork.isConnectedOrConnecting
    }
}