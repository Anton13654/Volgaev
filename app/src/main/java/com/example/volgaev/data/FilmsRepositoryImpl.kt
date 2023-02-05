package com.example.volgaev.data

import android.content.Context
import com.example.volgaev.data.database.FilmsDao
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.data.database.models.ShortFilm
import com.example.volgaev.domain.FilmsRepository

class FilmsRepositoryImpl(
    filmsDao: FilmsDao,
    context: Context
): FilmsRepository {
    override fun addFilmOnFavourites(film: Film) {
        TODO("Not yet implemented")
    }

    override fun getListFavourites(): List<ShortFilm> {
        return listOf(
            ShortFilm(0, "name1", 1990, 0),
            ShortFilm(1, "name2", 1990, 0),
            ShortFilm(2, "name3", 1990, 0)

        )
    }

    override fun getListFromServer(): List<ShortFilm> {
        return listOf(
            ShortFilm(0, "name1", 1990, 0),
            ShortFilm(1, "name2", 1990, 0),
            ShortFilm(2, "name3", 1990, 0)

        )
    }

    override fun getFilmFromServer(): Film {
        TODO("Not yet implemented")
    }

}