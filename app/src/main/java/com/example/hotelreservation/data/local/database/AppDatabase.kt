package com.example.hotelreservation.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.hotelreservation.data.local.dao.HotelDao
import com.example.hotelreservation.data.local.entity.HotelModel

@Database(entities = [HotelModel::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hotelDao(): HotelDao
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE hotels ADD COLUMN address TEXT NOT NULL DEFAULT 'undefined'")
    }
}
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE hotels ADD COLUMN rooms INTEGER NOT NULL DEFAULT 0")
    }
}