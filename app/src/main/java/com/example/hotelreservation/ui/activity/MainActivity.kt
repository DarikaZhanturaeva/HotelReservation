 package com.example.hotelreservation.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hotelreservation.R
import com.example.hotelreservation.ui.adapter.ViewPagerAdapter
import com.example.hotelreservation.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

 class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
     private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment

        navController = navHostFragment.navController


        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager2)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> ARG_HOTELS
                1 -> ARG_BOOKING_HOTEL
                else -> null
            }
        }.attach()
    }

     companion object {
         const val ARG_HOTELS = "Отели"
         const val ARG_BOOKING_HOTEL = "Заброниванные"
     }
}