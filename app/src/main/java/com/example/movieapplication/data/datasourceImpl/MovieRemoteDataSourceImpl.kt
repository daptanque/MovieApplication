package com.example.movieapplication.data.datasourceImpl

import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.datasource.MovieRemoteDataSource
import com.example.movieapplication.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String) : MovieRemoteDataSource{
    //connects the api with the datasource


    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)

}