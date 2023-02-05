package com.example.volgaev.domain

import com.example.volgaev.data.FilmFromServer
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.data.database.models.ShortFilm

interface FilmsRepository {

    fun addFilmOnFavourites(film: Film)

    fun getListFavourites(): List<ShortFilm>

    fun getListFromServer(): List<ShortFilm>

    fun getFilmFromServer(): Film
}