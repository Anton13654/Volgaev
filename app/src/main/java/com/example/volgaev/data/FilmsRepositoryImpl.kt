package com.example.volgaev.data

import android.content.Context
import com.example.volgaev.data.database.FilmsDao
import com.example.volgaev.domain.FilmsRepository

class FilmsRepositoryImpl(
    filmsDao: FilmsDao,
    context: Context
): FilmsRepository {

}