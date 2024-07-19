package com.example.hotelreservation.di

import org.koin.dsl.module

val appModule = listOf(
    networkModule,
    repositoryModule,
    viewModelModule
)