package com.example.volgaev.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.volgaev.data.database.models.FavouriteFilm

@Database(entities = [FavouriteFilm::class], version = 1, exportSchema = false )
abstract class FilmsDatabase: RoomDatabase() {

    abstract fun filmsDao(): FilmsDao
}