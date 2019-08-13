package com.lyh.kotlin_example.view.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lyh.kotlin_example.R
import com.lyh.kotlin_example.util.replace
import com.lyh.kotlin_example.view.home.HomeFragment

class BottomNavActivity : AppCompatActivity() {

    private val homeFragment by lazy {
       HomeFragment.newInstance()
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replace(R.id.container, homeFragment, HomeFragment::class.java.name)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        replace(R.id.container, homeFragment, HomeFragment::class.java.name)

    }
}
