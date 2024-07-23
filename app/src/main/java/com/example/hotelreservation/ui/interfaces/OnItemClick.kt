package com.example.hotelreservation.ui.interfaces

import com.example.hotelreservation.data.local.entity.HotelModel

interface OnItemClick {
    fun onClick(hotelModel: HotelModel)
}