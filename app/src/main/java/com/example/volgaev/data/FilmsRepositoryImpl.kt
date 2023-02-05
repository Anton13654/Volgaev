package com.example.volgaev.data

import android.content.Context
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
        /*return listOf(
            ShortFilm(0, "Шерлок", 1990, 0),
            ShortFilm(1, "Чебурашка", 1990, 0),
            ShortFilm(2, "Аватар", 1990, 0)
        )

         */
    }

    override suspend fun getListFromServer(): List<ShortFilm> {
        var shortInfo: MutableList<ShortFilm> = mutableListOf()

        for(i in 0..9){
            shortInfo += api.getPopular20(i).films.toListShortInfo()
        }

        return shortInfo
    }

    override fun getFilmFromServer(id: Int): FavouriteFilm {
       return FavouriteFilm(0,"dfg", "dsgf", "dsgf", "dg","dg", "353")
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