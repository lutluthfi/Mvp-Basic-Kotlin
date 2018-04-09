package com.example.lutluthfi.mvpbasickotlin.ui.base

import android.app.ProgressDialog
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import butterknife.Unbinder
import com.example.lutluthfi.mvpbasickotlin.R
import com.example.lutluthfi.mvpbasickotlin.utils.CommonUtils
import com.example.lutluthfi.mvpbasickotlin.utils.NetworkUtils

abstract class BaseActivity : AppCompatActivity(), BaseIView {

    private var mProgressDialog: ProgressDialog? = null
    var mUnbinder: Unbinder? = null

    abstract fun setupView()

    override fun onDestroy() {
        mUnbinder?.unbind()
        super.onDestroy()
    }

    private fun showSnackbar(message: String) {
        val sb = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        val tv = sb.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        tv.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        sb.show()
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        mProgressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun isLoading(): Boolean? = mProgressDialog?.isShowing

    override fun isNetworkConnected(): Boolean? = NetworkUtils.isNetworkConnected(this)

    override fun onError(message: String?) =
            if (message != null) showSnackbar(message)
            else showSnackbar(getString(R.string.error_general))

    override fun onError(resId: Int) = showSnackbar(getString(resId))

    override fun showMessage(message: String?) =
            if (message != null) Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, getString(R.string.error_general), Toast.LENGTH_SHORT).show()

    override fun showMessage(resId: Int) = Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()

    override fun printLog(tag: String, message: String?) =
            if (message != null) Log.d(tag, message)
            else Log.d(tag, getString(R.string.error_general))

    override fun printLog(tag: String, resId: Int) = Log.d(tag, getString(resId))

    override fun printLog(tag: String, message: String?, tr: Throwable) =
            if (message != null) Log.d(tag, message, tr)
            else Log.d(tag, getString(R.string.error_general), tr)

    override fun printLog(tag: String, resId: Int, tr: Throwable) = Log.d(tag, getString(resId), tr)
}