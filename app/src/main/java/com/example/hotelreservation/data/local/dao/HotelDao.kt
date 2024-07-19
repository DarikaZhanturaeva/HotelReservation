package com.example.hotelreservation.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hotelreservation.data.local.entity.HotelModel

@Dao
interface HotelDao {

    @Query("SELECT * FROM hotels")
    fun getAllHotels(): LiveData<List<HotelModel>>

    @Query("SELECT * FROM hotels WHERE id = :id")
    fun getHotelById(id: Int): HotelModel

    @Insert
    suspend fun insertHotel(hotel: HotelModel)

    @Delete
    suspend fun deletePills(hotel: HotelModel)

    @Update
    suspend fun updatePills(hotel: HotelModel)

}