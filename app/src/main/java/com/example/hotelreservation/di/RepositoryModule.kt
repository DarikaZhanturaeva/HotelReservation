package com.example.hotelreservation.di

import com.example.hotelreservation.data.repository.HotelRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module {

    single { HotelRepository(get()) }

}