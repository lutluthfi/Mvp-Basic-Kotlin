package com.example.lutluthfi.mvpbasickotlin

import android.app.Application
import com.example.lutluthfi.mvpbasickotlin.data.AppDataManager
import com.example.lutluthfi.mvpbasickotlin.data.DataManager
import com.example.lutluthfi.mvpbasickotlin.data.network.ApiHelper
import com.example.lutluthfi.mvpbasickotlin.data.network.AppApiHelper
import com.example.lutluthfi.mvpbasickotlin.data.preferences.AppPreferencesHelper
import com.example.lutluthfi.mvpbasickotlin.data.preferences.PreferencesHelper


class MvpBasicApp : Application() {

    private lateinit var mDataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        val apiHelper: ApiHelper = AppApiHelper()
        val preferencesHelper: PreferencesHelper = AppPreferencesHelper(applicationContext)
        mDataManager = AppDataManager(preferencesHelper, apiHelper)
    }

    fun getDataManager(): DataManager? {
        return mDataManager
    }
}