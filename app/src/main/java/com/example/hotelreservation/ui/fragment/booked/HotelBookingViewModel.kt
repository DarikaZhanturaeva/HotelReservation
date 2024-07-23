package com.example.hotelreservation.ui.fragment.booked

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.data.repository.HotelRepository
import kotlinx.coroutines.launch

class HotelBookingViewModel(
    private val repository: HotelRepository
) : ViewModel() {

    fun getHotelById(id: Int): LiveData<HotelModel> = repository.getHotelById(id)

    fun updateHotel(hotelModel: HotelModel) = viewModelScope.launch {
        repository.updateHotel(hotelModel)
    }
    fun deleteHotel(hotelModel: HotelModel) = viewModelScope.launch {
        repository.deleteHotel(hotelModel)
    }
}