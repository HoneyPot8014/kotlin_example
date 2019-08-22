package com.lyh.kotlin_example.data.source.local

import com.lyh.kotlin_example.data.model.ImageModel
import com.lyh.kotlin_example.data.source.ImageDataSource

object ImageLocalDataSource : ImageDataSource {

    override fun loadImageFileName(imageModelList: (List<ImageModel>) -> Unit) {
        val list = mutableListOf<ImageModel>()
        for (index in 1..10) {
            val name = String.format("sample_%02d", index)
            list.add(ImageModel(name, name))
        }
        imageModelList(list)
    }
}
