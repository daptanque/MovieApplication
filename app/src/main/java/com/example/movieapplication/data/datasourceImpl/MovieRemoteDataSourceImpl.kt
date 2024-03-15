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
        tmdbService.getPopularMovies(apiKey, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MjI4Y2M1NDc5YTgzOWQ5NDViZjM4ZGRmOGQzODg0ZiIsInN1YiI6IjY1ZjJiNjhlZWVhMzRkMDE2NDE0MzFkZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RcmYzvuxbODTtoQo1XJUGMoElbiJ5CK3Bj63wxpHamc")

}