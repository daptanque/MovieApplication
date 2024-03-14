package com.example.movieapplication.data.datasource

import com.example.movieapplication.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies() : Response<MovieList>
}