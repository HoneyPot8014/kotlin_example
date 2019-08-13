package com.lyh.kotlin_example.view.bottomsheet


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lyh.kotlin_example.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        const val KEY_HOME = "keyHomeFragment"

        @JvmStatic
        fun newInstance(key: String?): HomeFragment {
            return HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_HOME, key)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_home?.text = arguments?.getString(KEY_HOME).toString()
    }


}
