package com.example.movieapplication.presentation.di

import com.example.movieapplication.domain.repository.MovieRepository
import com.example.movieapplication.domain.usecases.GetMoviesUseCase
import com.example.movieapplication.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }
}