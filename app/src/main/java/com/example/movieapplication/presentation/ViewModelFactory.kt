package com.example.movieapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.domain.usecases.GetMoviesUseCase
import com.example.movieapplication.domain.usecases.UpdateMoviesUseCase

class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }



}