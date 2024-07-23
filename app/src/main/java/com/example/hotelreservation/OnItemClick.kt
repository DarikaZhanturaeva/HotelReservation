package com.example.hotelreservation

import com.example.hotelreservation.data.local.entity.HotelModel

interface OnItemClick {
    fun onClick(hotelModel: HotelModel)
}