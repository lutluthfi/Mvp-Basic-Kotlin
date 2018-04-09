package com.example.lutluthfi.mvpbasickotlin.ui.base

interface BaseIPresenter<V : BaseIView> {

    fun onAttach(baseView: V?)

    fun onDetach()

    fun getView(): V?
}