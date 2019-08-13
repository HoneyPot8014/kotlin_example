package com.lyh.kotlin_example.view.home

interface HomeContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showImage(imageName: String?)

    }

    interface Presenter {

        fun loadImage()
    }
}