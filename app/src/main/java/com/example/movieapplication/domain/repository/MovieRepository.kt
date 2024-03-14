package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?

}