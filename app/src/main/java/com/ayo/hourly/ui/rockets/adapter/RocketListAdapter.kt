package com.ayo.hourly.ui.rockets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayo.domain.model.RocketDomain
import com.ayo.hourly.R
import com.ayo.hourly.ui.rockets.adapter.viewholder.RocketViewHolder
import kotlinx.android.synthetic.main.item_launch.view.*

class RocketListAdapter(private val listener: ItemClickListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList = listOf<RocketDomain>()

    fun getItem(position: Int): RocketDomain = itemList[position]

    fun update(list: List<RocketDomain>?) {
        list?.let {
            itemList = it.toMutableList()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_launch, parent, false)
        return RocketViewHolder(view, listener)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val rocket = itemList[position]
        holder.itemView.ui_name.text = rocket.name
        holder.itemView.ui_country.text = rocket.country
        holder.itemView.ui_engine_count.text = rocket.engines?.number?.toString()
    }

    interface ItemClickListener {
        fun onClick(position: Int)
    }
}