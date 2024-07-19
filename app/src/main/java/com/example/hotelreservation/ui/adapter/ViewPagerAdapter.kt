package com.example.hotelreservation.ui.adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hotelreservation.ui.fragment.HotelBookingFragment
import com.example.hotelreservation.ui.fragment.HotelsFragment


class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HotelsFragment()
            1 -> HotelBookingFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}