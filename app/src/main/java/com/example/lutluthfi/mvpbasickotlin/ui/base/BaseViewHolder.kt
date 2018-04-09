package com.example.lutluthfi.mvpbasickotlin.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    protected var mCurrentPosition: Int? = null

    open fun onBind(position: Int) {
        this.mCurrentPosition = position
    }
}