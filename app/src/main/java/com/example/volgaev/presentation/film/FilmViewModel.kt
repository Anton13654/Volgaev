package com.example.volgaev.presentation.film

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volgaev.data.database.models.FavouriteFilm
import com.example.volgaev.domain.GetFilmFromServerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
 private val getFilmFromServerUseCase: GetFilmFromServerUseCase
): ViewModel() {

    private val _film: MutableStateFlow<FavouriteFilm?> = MutableStateFlow(null)
    val film = _film.asStateFlow()

    fun getFilm(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _film.value = getFilmFromServerUseCase(id)
        }
    }

}