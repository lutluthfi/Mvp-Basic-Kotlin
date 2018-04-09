package com.example.lutluthfi.mvpbasickotlin.ui.main

import android.os.Bundle
import android.support.design.R.id.message
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.LinearLayout
import butterknife.ButterKnife
import com.example.lutluthfi.mvpbasickotlin.MvpBasicApp
import com.example.lutluthfi.mvpbasickotlin.R
import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.example.lutluthfi.mvpbasickotlin.ui.adapter.NewsAdapter
import com.example.lutluthfi.mvpbasickotlin.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import io.reactivex.disposables.CompositeDisposable

class MainActivity : BaseActivity(), MainIView, NewsAdapter.Callback {

    private lateinit var mPresenter: MainIPresenter<MainIView>
    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenter((application as MvpBasicApp).getDataManager(), CompositeDisposable())
        mPresenter.onAttach(this)
        setupView()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home ->
                mPresenter.fetchNewsByPage(1)
            R.id.navigation_dashboard -> showMessage(R.string.title_dashboard)
            R.id.navigation_notifications -> showMessage(R.string.title_notifications)
        }
        return true
    }

    override fun setupView() {
        navigation.setOnNavigationItemSelectedListener(this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayout.VERTICAL
        rvNews.setHasFixedSize(true)
        rvNews.layoutManager = layoutManager
        mAdapter = NewsAdapter(this)
        rvNews.adapter = mAdapter
    }

    override fun onNewsItemClick(news: BeritaResponse.Berita) {
        news.judul?.let { showMessage(it) }
    }

    override fun updateNews(news: BeritaResponse.Beritas) {
        news.data?.let { mAdapter.addNews(it) }
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }
}