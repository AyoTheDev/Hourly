package com.ayo.spacex.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ayo.spacex.ui.adapter.RocketListAdapter

class RocketViewHolder(itemView: View, private val listener: RocketListAdapter.ItemClickListener?) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        listener?.onClick(layoutPosition)
    }
}