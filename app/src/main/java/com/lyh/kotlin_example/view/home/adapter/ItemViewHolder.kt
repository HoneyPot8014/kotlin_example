package com.lyh.kotlin_example.view.home.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lyh.kotlin_example.R
import com.lyh.kotlin_example.data.model.ImageModel

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.tv_item_view)
    private val imageView: ImageView = itemView.findViewById(R.id.iv_item_view)

    fun onBind(imageModel: ImageModel) {
        imageModel.let {
            val context = itemView.context
            textView.text = it.fileName
            imageView.setImageResource(context.resources.getIdentifier(it.fileName, "drawable", context.packageName))
        }
    }
}