package com.example.volgaev.domain

import com.example.volgaev.data.database.models.Film

interface FilmsRepository {

    fun addFilmOnFavourites(film: Film)

    fun getListFavourites(): List<Film>

    fun getListFromServer(): List<Film>

    fun getFilmFromServer(): Film
}