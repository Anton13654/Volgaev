package com.example.volgaev.data

import android.content.Context
import android.util.Log
import com.example.volgaev.data.database.FilmsDao
import com.example.volgaev.data.database.models.FavouriteFilm
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.data.database.models.FilmFromServer
import com.example.volgaev.data.database.models.ShortFilm
import com.example.volgaev.domain.FilmsRepository

class FilmsRepositoryImpl(
    private val filmsDao: FilmsDao,
    val context: Context,
    val api: Api
): FilmsRepository {

    override fun addFilmOnFavourites(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getListFavourites(): List<ShortFilm> {

        return filmsDao.takeListFavourites().toListShortInfo()

    }

    override suspend fun getListFromServer(): List<ShortFilm> {
        var shortInfo: MutableList<ShortFilm> = mutableListOf()

        for(i in 1..10){
            shortInfo += api.getPopular20(i).films.toListShortInfo()
        }

        return shortInfo
    }

    override suspend fun getFilmFromServer(id: Int): FavouriteFilm {
        var newFilm = api.getFilmInfo(id)
        return FavouriteFilm(newFilm.kinopoiskId, newFilm.nameRu, newFilm.posterUrl, newFilm.description, newFilm.genres[0].toString(), newFilm.countries[0].toString(), newFilm.year.toString())
    }

    override fun getFilmFromBD(id: Int): FavouriteFilm? {
        TODO("Not yet implemented")
    }

}

    @JvmName("toListShortInfoFavouriteFilm")
    fun List<FavouriteFilm>.toListShortInfo(): List<ShortFilm>{
        var listShortInfo: MutableList<ShortFilm> = mutableListOf()
        for(i in 0 until this.size){
            listShortInfo.add(ShortFilm(this[i].id, this[i].name, this[i].year, this[i].poster))
        }
        return listShortInfo
    }

    fun List<Film>.toListShortInfo(): List<ShortFilm>{
        var listShortInfo: MutableList<ShortFilm> = mutableListOf()
        for(i in 0 until this.size){
            listShortInfo.add(ShortFilm(this[i].filmId, this[i].nameRu, this[i].year, this[i].posterUrl))
        }
        return listShortInfo
    }