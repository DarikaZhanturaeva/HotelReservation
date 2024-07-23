package com.example.hotelreservation.di

import com.example.hotelreservation.ui.fragment.all_hotels.HotelViewModel
import com.example.hotelreservation.ui.fragment.booked.HotelBookingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {

    viewModel { HotelViewModel(get()) }
    viewModel { HotelBookingViewModel(get()) }
}