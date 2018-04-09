package com.example.lutluthfi.mvpbasickotlin.data

import com.example.lutluthfi.mvpbasickotlin.data.network.ApiHelper
import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.example.lutluthfi.mvpbasickotlin.data.preferences.PreferencesHelper
import io.reactivex.Observable

class AppDataManager(private var mPreferencesHelper: PreferencesHelper, private var mApiHelper: ApiHelper) : DataManager {

    override fun clear() {
        mPreferencesHelper.clear()
    }

    override fun isFirstTimeOpenApplication(): Boolean = mPreferencesHelper.isFirstTimeOpenApplication()

    override fun setIsFirstTimeOpenApplication(isFirstTime: Boolean) = mPreferencesHelper.setIsFirstTimeOpenApplication(isFirstTime)

    override fun getNewsByPage(page: Int): Observable<BeritaResponse.Beritas> = mApiHelper.getNewsByPage(page)

    override fun getNewsById(id: String): Observable<BeritaResponse.Berita> = mApiHelper.getNewsById(id)

}