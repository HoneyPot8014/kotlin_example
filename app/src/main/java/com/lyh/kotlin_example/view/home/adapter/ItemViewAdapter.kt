package com.lyh.kotlin_example.view.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lyh.kotlin_example.R
import com.lyh.kotlin_example.data.model.ImageModel

class ItemViewAdapter: RecyclerView.Adapter<ItemViewHolder>() {

    private val itemList by lazy {
        mutableListOf<ImageModel>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_image_view, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    fun addItem(item: ImageModel) {
        itemList.add(item)
        notifyDataSetChanged()
    }


    fun setItem(list: List<ImageModel>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }


}