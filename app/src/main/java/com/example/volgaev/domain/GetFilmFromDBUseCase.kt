package com.example.volgaev.domain

class GetFilmFromDBUseCase(private val repository: FilmsRepository) {

    suspend operator fun invoke(id: Int){
        repository.getFilmFromBD(id)
    }
}