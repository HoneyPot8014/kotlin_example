package com.lyh.kotlin_example.view.home

import android.os.AsyncTask
import com.lyh.kotlin_example.data.repository.ImageRepository

class HomePresenter(private val view: HomeContract.View,
                    private val imageRepository: ImageRepository) : HomeContract.Presenter {

    override fun loadImage() {
        ImageAsyncTask(view, imageRepository).execute()
    }

    class ImageAsyncTask(private val view: HomeContract.View,
                         private val imageRepository: ImageRepository) : AsyncTask<Unit, Unit, Unit>() {

        override fun onPreExecute() {
            super.onPreExecute()
            view.showProgress()
        }

        override fun doInBackground(vararg params: Unit?) {
            Thread.sleep(1000)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            view.hideProgress()
            imageRepository.loadImageFileName {
                view.showImage(it)
            }
        }

    }

}