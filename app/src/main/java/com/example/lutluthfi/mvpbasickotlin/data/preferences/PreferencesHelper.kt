package com.example.lutluthfi.mvpbasickotlin.data.preferences

interface PreferencesHelper {

    fun clear()

    fun isFirstTimeOpenApplication(): Boolean

    fun setIsFirstTimeOpenApplication(isFirstTime: Boolean)
}