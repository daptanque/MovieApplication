package com.example.movieapplication.domain.usecases

import com.example.movieapplication.data.model.Movie
import com.example.movieapplication.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository){
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}