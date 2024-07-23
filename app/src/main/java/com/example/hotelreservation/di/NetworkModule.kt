package com.example.hotelreservation.di

import androidx.room.Room
import com.example.hotelreservation.data.local.database.AppDatabase
import com.example.hotelreservation.data.local.database.MIGRATION_1_2
import com.example.hotelreservation.data.local.database.MIGRATION_2_3
import org.koin.dsl.module

val networkModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "hotels").addMigrations(
            MIGRATION_1_2, MIGRATION_2_3)
            .build()
    }

    single {
        get<AppDatabase>().hotelDao()
    }
}

