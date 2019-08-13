package com.lyh.kotlin_example.view.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.lyh.kotlin_example.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    companion object {
        @JvmStatic
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private val presenter: HomePresenter by lazy {
        HomePresenter(this)
    }

    override fun showImage(imageName: String?) {
        iv_home?.setImageResource(resources.getIdentifier(imageName, "drawable", context?.packageName))
    }

    override fun hideProgress() {
        if(pg_home.isVisible) {
            pg_home.visibility = View.GONE
        }
    }

    override fun showProgress() {
        if(!pg_home.isVisible) {
            pg_home.visibility = View.VISIBLE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadImage()
    }

}
