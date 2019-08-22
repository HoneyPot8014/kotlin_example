package com.lyh.kotlin_example.data.source

import com.lyh.kotlin_example.data.model.ImageModel

interface ImageDataSource {

    fun loadImageFileName(imageModelList: (List<ImageModel>) -> Unit)

}