package com.example.lutluthfi.mvpbasickotlin.ui.main

import com.example.lutluthfi.mvpbasickotlin.ui.base.BaseIPresenter

interface MainIPresenter<V : MainIView> : BaseIPresenter<V> {

    fun fetchNewsByPage(page: Int)
}