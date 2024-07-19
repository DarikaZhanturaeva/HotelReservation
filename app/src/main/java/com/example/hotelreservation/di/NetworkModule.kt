package com.example.hotelreservation.di

import android.content.Context
import androidx.room.Room
import com.example.hotelreservation.data.local.dao.HotelDao
import com.example.hotelreservation.data.local.database.AppDatabase
import org.koin.dsl.module

val networkModule = module {

    single { provideDao(get()) }
    single { provideDatabase(get()) }

}

fun provideDao(database: AppDatabase): HotelDao {
    return database.hotelDao()
}

fun provideDatabase(
    context: Context
) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "home_data"
).allowMainThreadQueries().build()