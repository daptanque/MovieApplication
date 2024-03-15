package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.MovieRepositoryImpl
import com.example.movieapplication.data.datasource.MovieCacheDataSource
import com.example.movieapplication.data.datasource.MovieLocalDataSource
import com.example.movieapplication.data.datasource.MovieRemoteDataSource
import com.example.movieapplication.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }
}