package com.example.hotelreservation.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotels")
data class HotelModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String
)