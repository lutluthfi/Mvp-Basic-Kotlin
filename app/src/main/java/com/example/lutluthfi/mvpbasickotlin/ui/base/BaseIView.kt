package com.example.lutluthfi.mvpbasickotlin.ui.base

import android.support.annotation.StringRes

interface BaseIView {

    fun showLoading()

    fun hideLoading()

    fun isLoading(): Boolean?

    fun isNetworkConnected(): Boolean?

    fun onError(message: String?)

    fun onError(@StringRes resId: Int)

    fun showMessage(message: String?)

    fun showMessage(@StringRes resId: Int)

    fun printLog(tag: String, message: String?): Int

    fun printLog(tag: String, @StringRes resId: Int): Int

    fun printLog(tag: String, message: String?, tr: Throwable): Int

    fun printLog(tag: String, @StringRes resId: Int, tr: Throwable): Int
}