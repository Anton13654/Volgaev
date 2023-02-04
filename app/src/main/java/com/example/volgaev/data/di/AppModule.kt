package com.example.volgaev.data.di

import android.content.Context
import androidx.room.Room
import com.example.volgaev.data.FilmsRepositoryImpl
import com.example.volgaev.data.database.FilmsDao
import com.example.volgaev.data.database.FilmsDatabase
import com.example.volgaev.domain.FilmsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFilmsRepository(filmsDao: FilmsDao, @ApplicationContext context: Context): FilmsRepository = FilmsRepositoryImpl(filmsDao, context)

    @Provides
    @Singleton
    fun provideFilmsDatabase(@ApplicationContext context: Context): FilmsDatabase = Room.databaseBuilder(context,
        FilmsDatabase::class.java,
        "FilmsDatabase"
    ).build()

    @Provides
    @Singleton
    fun provideFilmsDao(filmsDatabase: FilmsDatabase): FilmsDao = filmsDatabase.filmsDao()

}