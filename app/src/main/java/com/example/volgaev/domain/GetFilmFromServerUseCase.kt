package com.example.volgaev.domain

import com.example.volgaev.data.database.models.FavouriteFilm

class GetFilmFromServerUseCase(val repository: FilmsRepository) {

    suspend operator fun invoke(id: Int): FavouriteFilm? {
        return repository.getFilmFromServer(id)
    }
}