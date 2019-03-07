package com.ayo.spacex.ui.rockets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayo.data.local.model.Rocket
import com.ayo.spacex.R
import com.ayo.spacex.ui.rockets.adapter.viewholder.RocketViewHolder
import kotlinx.android.synthetic.main.item_launch.view.*

class RocketListAdapter(private val listener: ItemClickListener?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var itemList = listOf<Rocket>()

    fun getItem(position: Int): Rocket = itemList[position]

    fun update(list: List<Rocket>) {
        itemList = list.toMutableList()
        notifyDataSetChanged()
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
        //holder.itemView.ui_engine_count.text = rocket.engines?.number?.toString()

        //todo create models for app layer
    }

    interface ItemClickListener {
        fun onClick(position: Int)
    }
}