package com.example.volgaev.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
class FavouriteFilm (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val poster: String,
    val description: String,
    val genre: String,
    val country: String,
    val year: String
    )
{
    fun FavouriteFilm.toShortFilm() = ShortFilm(this.id, this.name, this.year, this.poster)
}


