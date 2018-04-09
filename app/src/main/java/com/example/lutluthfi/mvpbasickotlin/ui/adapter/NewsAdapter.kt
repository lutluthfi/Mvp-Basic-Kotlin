package com.example.lutluthfi.mvpbasickotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lutluthfi.mvpbasickotlin.R
import com.example.lutluthfi.mvpbasickotlin.data.network.model.BeritaResponse
import com.example.lutluthfi.mvpbasickotlin.ui.base.BaseViewHolder
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_content_news.view.*

class NewsAdapter(private var mCallback: Callback?) : RecyclerView.Adapter<BaseViewHolder>() {

    private val mNews = ArrayList<BeritaResponse.Berita>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            NewsViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_list_content_news, parent, false))

    override fun getItemCount(): Int = this.mNews.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.onBind(position)

    fun addNews(news: List<BeritaResponse.Berita>) {
        this.mNews.addAll(news)
        notifyDataSetChanged()
    }

    fun clearNews() {
        this.mNews.clear()
        notifyDataSetChanged()
    }

    // Describe interface/callback of adapter for News
    interface Callback {
        fun onNewsItemClick(news: BeritaResponse.Berita)
    }

    // Describe inner class of view holder for News
    inner class NewsViewHolder(itemView: View) : BaseViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
            itemView.setOnClickListener(this)
        }

        override fun onBind(position: Int) {
            super.onBind(position)
            mNews[position].judul?.let { itemView.tvNewsTitle.text = it }
            mNews[position].konten?.let { itemView.tvNewsContent.text = it }
            mNews[position].foto?.let { Glide.with(itemView.context).load(it).asBitmap().centerCrop().into(itemView.ivNewsPoster) }
        }

        override fun onClick(v: View?) {
            mCallback?.onNewsItemClick(mNews[adapterPosition])
        }
    }
}