package com.example.hotelreservation.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.data.repository.HotelRepository
import kotlinx.coroutines.launch

class HotelViewModel(
    private val repository: HotelRepository
) : ViewModel() {
    fun getAllHotels(): LiveData<List<HotelModel>> = repository.getAllHotels()
}