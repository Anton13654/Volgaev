package com.example.volgaev.data.di

import android.content.Context
import androidx.room.Room
import com.example.volgaev.data.Api
import com.example.volgaev.data.FilmsRepositoryImpl
import com.example.volgaev.data.HeaderInterceptor
import com.example.volgaev.data.database.FilmsDao
import com.example.volgaev.data.database.FilmsDatabase
import com.example.volgaev.domain.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path
import retrofit2.http.Url
import javax.inject.Singleton
const val PATH = "https://kinopoiskapiunofficial.tech"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetFilmFromServerUseCase(repository: FilmsRepository): GetFilmFromServerUseCase = GetFilmFromServerUseCase(repository)

    @Provides
    @Singleton
    fun provideAddFilmOnFavouriteUseCase(repository: FilmsRepository): AddFilmOnFavouritesUseCase = AddFilmOnFavouritesUseCase(repository)


    @Provides
    @Singleton
    fun provideGetListFavouritesUseCase(repository: FilmsRepository): GetListFavouritesUseCase = GetListFavouritesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetListFromServerUseCase(repository: FilmsRepository): GetListFromServerUseCase = GetListFromServerUseCase(repository)


    @Provides
    @Singleton
    fun provideFilmsRepository(filmsDao: FilmsDao, @ApplicationContext context: Context, api: Api): FilmsRepository = FilmsRepositoryImpl(filmsDao, context, api)

    @Provides
    @Singleton
    fun provideFilmsDatabase(@ApplicationContext context: Context): FilmsDatabase = Room.databaseBuilder(context,
        FilmsDatabase::class.java,
        "FilmsDatabase"
    ).build()

    @Provides
    @Singleton
    fun provideFilmsDao(filmsDatabase: FilmsDatabase): FilmsDao = filmsDatabase.filmsDao()


    @Provides
    @Singleton
    fun provideServerStateApi(okHttpClient: OkHttpClient): Api =  Retrofit.Builder()
        .baseUrl(PATH)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
        .build()
        .create(Api::class.java)

    @Provides
    @Singleton
    fun provideOkHttp(headerInterceptor: HeaderInterceptor): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(headerInterceptor).addInterceptor(HttpLoggingInterceptor()).build()
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): HeaderInterceptor = HeaderInterceptor()



}