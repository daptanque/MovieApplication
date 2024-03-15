package com.example.movieapplication.presentation.di

import com.example.movieapplication.domain.usecases.GetMoviesUseCase
import com.example.movieapplication.domain.usecases.UpdateMoviesUseCase
import com.example.movieapplication.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {

        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase)
    }

}