package com.example.hotelreservation.ui.fragment.all_hotels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelreservation.data.local.entity.HotelModel
import com.example.hotelreservation.data.repository.HotelRepository
import kotlinx.coroutines.launch

class HotelViewModel(
    private val repository: HotelRepository
) : ViewModel() {

    fun getAllHotels(): LiveData<List<HotelModel>> {
        return repository.getAllHotels()}

    fun insertHotel(hotelModel: HotelModel) = viewModelScope.launch {
        Log.d("HotelViewModel", "Inserting hotel: ${hotelModel.name}")
        repository.insertHotel(hotelModel)
    }
}