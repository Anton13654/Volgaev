package com.example.volgaev.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.volgaev.data.database.models.FavouriteFilm

@Dao
interface FilmsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addInFavourites(favouriteFilm: FavouriteFilm)

    @Query("SELECT * FROM favourites")
    fun takeListFavourites(): List<FavouriteFilm>

    @Query ("SELECT * FROM favourites WHERE id = :id")
    fun getFilmById(id: Int) : FavouriteFilm
}