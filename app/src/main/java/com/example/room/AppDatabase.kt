package com.example.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.model.MovieData
import com.example.model.MovieDataDao


@Database(entities = [MovieData::class], version = 8, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rideDataDao(): MovieDataDao

}