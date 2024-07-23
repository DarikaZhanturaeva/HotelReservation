package com.example.hotelreservation.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.hotelreservation.data.local.dao.HotelDao
import com.example.hotelreservation.data.local.entity.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelRepository(
    private val hotelDao: HotelDao
) {
    fun getAllHotels(): LiveData<List<HotelModel>> = hotelDao.getAllHotels()

    fun getHotelById(id: Int): LiveData<HotelModel> = hotelDao.getHotelById(id)

    suspend fun insertHotel(hotel: HotelModel) = withContext(Dispatchers.IO) {
        Log.d("HotelRepository", "Inserting hotel: ${hotel.name}")
        hotelDao.insertHotel(hotel)
    }

    suspend fun updateHotel(hotel: HotelModel) {
        hotelDao.updateHotel(hotel)
    }

    suspend fun deleteHotel(hotel: HotelModel) {
        hotelDao.deleteHotel(hotel)
    }
}