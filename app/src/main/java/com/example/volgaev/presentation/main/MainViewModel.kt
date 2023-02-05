package com.example.volgaev.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volgaev.data.Section
import com.example.volgaev.data.database.models.ShortFilm
import com.example.volgaev.domain.AddFilmOnFavouritesUseCase
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
    private val getListFavouritesUseCase: GetListFavouritesUseCase,
    private val addFilmOnFavouritesUseCase: AddFilmOnFavouritesUseCase


): ViewModel() {


    private val _listFilms: MutableStateFlow<Pair<List<Int>, List<ShortFilm>>?> = MutableStateFlow(null)
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
            _listFilms.value = Pair(listFromFavourites.map { it.id }, listFromServer)
        }else{
            _listFilms.value = Pair(listFromFavourites.map { it.id }, listFromFavourites)
        }

    }

    fun addFavourite(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            addFilmOnFavouritesUseCase(id)
        }
    }
}