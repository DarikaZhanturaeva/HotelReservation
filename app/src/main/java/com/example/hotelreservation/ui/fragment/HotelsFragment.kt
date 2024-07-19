package com.example.hotelreservation.ui.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.hotelreservation.data.local.entity.HotelModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.hotelreservation.databinding.FragmentHotelsBinding
import com.example.hotelreservation.ui.base.BaseFragment
import kotlinx.coroutines.launch

class HotelsFragment : BaseFragment<FragmentHotelsBinding>(FragmentHotelsBinding::inflate) {

    private lateinit var hotelAdapter: HotelAdapter
    private val viewModel: HotelViewModel by viewModel()

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.getAllHotels().observe(viewLifecycleOwner, Observer { hotels ->
            hotels?.let {
                hotelAdapter.submitList(it)
            }
        })
    }

    private fun setupRecyclerView() {
        val adapter = HotelAdapter(
            arrayListOf(
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
                HotelModel(1, "  ", "https://cdn.worldota.net/t/1200x616/extranet/35/18/3518abb02db860639cc9825a513131b314f22fc5.JPEG"),
            )
        )
        binding.rvHotels.adapter = adapter
//        hotelAdapter = HotelAdapter()
//        binding.rvHotels.adapter = hotelAdapter
    }
}