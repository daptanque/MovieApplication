package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.datasource.MovieRemoteDataSource
import com.example.movieapplication.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }

}