package com.example.volgaev.data.database.models

import com.example.volgaev.data.database.models.Film

data class FilmFromServer(
    val films: List<Film>,
    val pagesCount: Int
)