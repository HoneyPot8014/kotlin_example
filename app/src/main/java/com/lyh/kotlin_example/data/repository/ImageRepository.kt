package com.lyh.kotlin_example.data.repository

import com.lyh.kotlin_example.data.model.ImageModel
import com.lyh.kotlin_example.data.source.ImageDataSource
import com.lyh.kotlin_example.data.source.local.ImageLocalDataSource

object ImageRepository : ImageDataSource {

    override fun loadImageFileName(imageModelList: (List<ImageModel>) -> Unit) {
        ImageLocalDataSource.loadImageFileName(imageModelList)
    }
}
