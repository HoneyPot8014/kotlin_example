package com.lyh.kotlin_example.data.source.local

import com.lyh.kotlin_example.data.source.ImageDataSource

object ImageLocalDataSource : ImageDataSource {

    override fun loadImageFileName(fileName: (String) -> Unit) {
        fileName(String.format("sample_%02d", (1..20).random()))
    }
}