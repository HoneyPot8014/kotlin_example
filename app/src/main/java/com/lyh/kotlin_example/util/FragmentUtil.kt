package com.lyh.kotlin_example.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replace(@IdRes containerId: Int, fragment: Fragment, tag: String? = null) {
    supportFragmentManager.beginTransaction().replace(containerId, fragment, tag).commit()
}