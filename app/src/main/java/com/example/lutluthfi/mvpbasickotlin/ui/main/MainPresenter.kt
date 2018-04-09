package com.example.lutluthfi.mvpbasickotlin.ui.main

import com.example.lutluthfi.mvpbasickotlin.R
import com.example.lutluthfi.mvpbasickotlin.data.DataManager
import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.example.lutluthfi.mvpbasickotlin.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter<V : MainIView>(mDataManager: DataManager?, mCompositeDisposable: CompositeDisposable?) : BasePresenter<V>(mDataManager, mCompositeDisposable), MainIPresenter<V> {

    val tag: String = "MainPresenter"

    override fun fetchNewsByPage(page: Int) {
        getView()?.printLog(tag, "fetchNewsByPage")
        getView()?.isLoading()
        getCompositeDisposable()?.add(getDataManager()!!
                .getNewsByPage(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BeritaResponse.Beritas>() {
                    override fun onComplete() {
                        getView()?.showMessage("Success fetching")
                    }

                    override fun onNext(t: BeritaResponse.Beritas) {
                        getView()?.updateNews(t)
                    }

                    override fun onError(e: Throwable) {
                        getView()?.printLog(tag, R.string.error_general)
                        getView()?.printLog(tag, e.message, e)
                    }
                }))
    }
}