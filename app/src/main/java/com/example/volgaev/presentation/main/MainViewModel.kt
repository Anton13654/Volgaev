package com.example.volgaev.presentation.main

import androidx.lifecycle.ViewModel
import com.example.volgaev.data.database.models.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    fun addFavourite(film: Film){

    }
}