package com.example.volgaev.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.volgaev.data.database.models.Film

@Database(entities = [Film::class], version = 1, exportSchema = false )
abstract class FilmsDatabase: RoomDatabase() {

    abstract fun filmsDao(): FilmsDao
}