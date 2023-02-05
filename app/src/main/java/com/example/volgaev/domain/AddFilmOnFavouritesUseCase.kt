package com.example.volgaev.domain

class AddFilmOnFavouritesUseCase(private val repository: FilmsRepository) {

    suspend operator fun invoke(id: Int){
        repository.addFilmOnFavourites(id)
    }
}