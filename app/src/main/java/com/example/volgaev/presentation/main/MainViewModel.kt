package com.example.volgaev.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volgaev.data.FilmFromServer
import com.example.volgaev.data.Section
import com.example.volgaev.data.database.models.Film
import com.example.volgaev.data.database.models.ShortFilm
import com.example.volgaev.domain.GetFilmFromServerUseCase
import com.example.volgaev.domain.GetListFavouritesUseCase
import com.example.volgaev.domain.GetListFromServerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListFromServerUseCase: GetListFromServerUseCase,
    private val getListFavouritesUseCase: GetListFavouritesUseCase


): ViewModel() {


    private val _listFilms: MutableStateFlow<List<ShortFilm>?> = MutableStateFlow(null)
    val listFilms = _listFilms.asStateFlow()
    var listFromServer: List<ShortFilm> = listOf()
    var listFromFavourites: List<ShortFilm> = listOf()

    fun getListFilms(){
        viewModelScope.launch(Dispatchers.IO) {
            listFromServer = getListFromServerUseCase()
            listFromFavourites = getListFavouritesUseCase()
            changeList(Section.Popular)
        }
    }

    fun changeList(section: Section){
        if(section == Section.Popular){
            _listFilms.value = listFromServer
        }else{
            _listFilms.value = listFromFavourites
        }

    }

    fun addFavourite(film: Film){

    }
}