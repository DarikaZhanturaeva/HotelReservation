package com.example.hotelreservation.ui.fragment.booked

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.hotelreservation.OnItemClick
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.databinding.FragmentHotelBookingBinding
import com.example.hotelreservation.ui.base.BaseFragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelBookingFragment :
    BaseFragment<FragmentHotelBookingBinding>(FragmentHotelBookingBinding::inflate), OnItemClick {

    private lateinit var hotelBookingAdapter: HotelBookingAdapter
    private val viewModel: HotelBookingViewModel by viewModel()
    private val args: HotelBookingFragmentArgs by navArgs()

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun setupObservers() {
        super.setupObservers()
        val hotelId = args.hotelId
        viewModel.getHotelById(hotelId).observe(viewLifecycleOwner, Observer { hotel ->
            if (hotel != null) {
                hotelBookingAdapter.submitList(listOf(hotel))
            } else {
                Toast.makeText(requireContext(), "Hotel not found", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecyclerView() {
        hotelBookingAdapter = HotelBookingAdapter(this)
        binding.rvBooking.adapter = hotelBookingAdapter
    }

    override fun onClick(hotelModel: HotelModel) {
        val action = HotelBookingFragmentDirections.actionHotelBookingFragmentToBookingDetailFragment(
            hotelModel.id,
            hotelModel.name,
            hotelModel.image,
            hotelModel.address
        )
        findNavController().navigate(action)
    }
}