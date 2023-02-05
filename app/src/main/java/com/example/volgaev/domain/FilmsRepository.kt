package com.example.volgaev.domain

import com.example.volgaev.data.database.models.FavouriteFilm
import com.example.volgaev.data.database.models.ShortFilm

interface FilmsRepository {

    fun addFilmOnFavourites(id: Int)

    fun getListFavourites(): List<ShortFilm>

    suspend fun getListFromServer(): List<ShortFilm>

    suspend fun getFilmFromServer(id: Int): FavouriteFilm

    fun getFilmFromBD(id: Int): FavouriteFilm?
}