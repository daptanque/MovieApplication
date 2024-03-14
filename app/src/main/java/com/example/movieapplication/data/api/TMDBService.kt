package com.example.movieapplication.data.api

import com.example.movieapplication.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "API_KEY"
        ) apiKey: String
    ) : Response<MovieList>




}