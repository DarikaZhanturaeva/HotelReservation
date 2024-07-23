package com.example.hotelreservation.data.local.dao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.hotelreservation.data.local.entity.HotelModel

@Dao
interface HotelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(hotel: HotelModel)

    @Update
    suspend fun updateHotel(hotel: HotelModel)

    @Delete
    suspend fun deleteHotel(hotel: HotelModel)

    @Query("SELECT * FROM hotels")
    fun getAllHotels(): LiveData<List<HotelModel>>

    @Query("SELECT * FROM hotels WHERE id = :id")
    fun getHotelById(id: Int): LiveData<HotelModel>
}