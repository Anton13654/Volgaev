package com.example.volgaev.data

import com.example.volgaev.data.database.models.FilmFromServer
import com.example.volgaev.data.database.models.FullInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface Api {

    @GET("/api/v2.2/films/top")
    suspend fun getPopular20(@Query("page") page: Int) : FilmFromServer

    @GET("/api/v2.2/films/{id}")
    suspend fun getFilmInfo(@Path("id") id: Int) : FullInfo


}