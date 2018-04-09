package com.example.lutluthfi.mvpbasickotlin.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.lutluthfi.mvpbasickotlin.utils.AppConstants

class AppPreferencesHelper(context: Context) : PreferencesHelper {
    private val KEY_IS_FIRST_TIME_OPEN_APPLICATION = "KEY_IS_FIRST_TIME_OPEN_APPLICATION"

    private val mPrefs: SharedPreferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)

    override fun clear() {
        mPrefs.edit { clear() }
    }

    override fun isFirstTimeOpenApplication(): Boolean = mPrefs.getBoolean(KEY_IS_FIRST_TIME_OPEN_APPLICATION, true)

    override fun setIsFirstTimeOpenApplication(isFirstTime: Boolean) {
        mPrefs.edit { putBoolean(KEY_IS_FIRST_TIME_OPEN_APPLICATION, isFirstTime) }
    }
}