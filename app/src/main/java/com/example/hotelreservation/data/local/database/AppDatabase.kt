package com.example.hotelreservation.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotelreservation.data.local.dao.HotelDao
import com.example.hotelreservation.data.local.entity.HotelModel

@Database(entities = [HotelModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun hotelDao(): HotelDao
} 