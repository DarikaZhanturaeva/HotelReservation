package com.example.hotelreservation.data.repository

import androidx.lifecycle.LiveData
import com.example.hotelreservation.data.local.dao.HotelDao
import com.example.hotelreservation.data.local.entity.HotelModel

class HotelRepository(
    private val hotelDao: HotelDao
) {
     fun getAllHotels(): LiveData<List<HotelModel>> = hotelDao.getAllHotels()

}