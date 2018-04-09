package com.example.lutluthfi.mvpbasickotlin.ui.main

import android.support.design.widget.BottomNavigationView
import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.example.lutluthfi.mvpbasickotlin.ui.base.BaseIView

interface MainIView : BaseIView, BottomNavigationView.OnNavigationItemSelectedListener {

    fun updateNews(news: BeritaResponse.Beritas)
}