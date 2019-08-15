package com.lyh.kotlin_example.data.source

interface ImageDataSource {

    fun loadImageFileName(fileName: (String) -> Unit)

}