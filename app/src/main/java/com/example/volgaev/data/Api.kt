package com.example.volgaev.data

import com.example.volgaev.data.database.models.FilmFromServer
import com.example.volgaev.data.database.models.FullInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("films/top")
    suspend fun getPopular20(@Query("page") page: Int) : FilmFromServer

    @GET("films/{id}")
    suspend fun getFilmInfo(@Path("id") id: Int) : FullInfo

}