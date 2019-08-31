package com.lyh.kotlin_example.view.home

import com.lyh.kotlin_example.data.model.ImageModel

interface HomeContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showImage(itemList: List<ImageModel>)

    }

    interface Presenter {

        fun loadImage()
    }
}