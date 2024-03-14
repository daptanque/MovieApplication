package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.datasource.MovieLocalDataSource
import com.example.movieapplication.data.datasourceImpl.MovieLocalDataSourceImpl
import com.example.movieapplication.data.db.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {


    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDAO)
    }



}