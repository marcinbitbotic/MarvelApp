package com.marvel.app.marvelapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.marvel.app.marvelapp.R
import com.marvel.app.marvelapp.extensions.inflate
import com.marvel.app.marvelapp.extensions.loadImg
import com.marvel.app.marvelapp.model.DataModel
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.*

/**
 * Created by Marcin Pogorzelski on 21/09/2017.
 */
class CustomAdapter (val listener: onViewSelectedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<DataModel>

    interface onViewSelectedListener {
        fun onItemSelected(item: DataModel)
    }

    init {
        items = ArrayList()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder as ItemViewHolder
        holder.bind(items[position] as DataModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(parent)
    }

    fun addItems(news: List<DataModel>) {
        items.addAll(news)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_layout)) {

        fun bind(item: DataModel) = with(itemView) {
            img_thumbnail.loadImg(item.photo)
            name.text = item.name
            desciption.text = item.power
            super.itemView.setOnClickListener { listener.onItemSelected(item)}
        }
    }

}