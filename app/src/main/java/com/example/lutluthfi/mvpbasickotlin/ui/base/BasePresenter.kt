package com.example.lutluthfi.mvpbasickotlin.ui.base

import com.example.lutluthfi.mvpbasickotlin.data.DataManager
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : BaseIView> constructor(private var mDataManager: DataManager? = null, private var mCompositeDisposable: CompositeDisposable? = null) : BaseIPresenter<V> {

    private var mView: V? = null
    private val isViewAttached: Boolean get() = mView != null

    override fun onAttach(baseView: V?) {
        mView = baseView
    }

    override fun onDetach() {
        mCompositeDisposable?.dispose()
        mView = null
    }

    override fun getView(): V? = mView

    protected fun getDataManager(): DataManager? = mDataManager

    protected fun getCompositeDisposable(): CompositeDisposable? = mCompositeDisposable
}