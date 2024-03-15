package com.example.movieapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapplication.domain.usecases.GetMoviesUseCase
import com.example.movieapplication.domain.usecases.UpdateMoviesUseCase

open class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private  val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel(){


    fun getMovies() = liveData{
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}