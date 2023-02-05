package com.example.volgaev.domain

import com.example.volgaev.data.database.models.ShortFilm

class GetListFromServerUseCase(private val repository: FilmsRepository) {

    suspend operator fun invoke(): List<ShortFilm> {
        return repository.getListFromServer()
    }
}