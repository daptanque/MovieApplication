package com.example.movieapplication.data

import com.example.movieapplication.data.datasource.MovieCacheDataSource
import com.example.movieapplication.data.datasource.MovieLocalDataSource
import com.example.movieapplication.data.datasource.MovieRemoteDataSource
import com.example.movieapplication.data.model.Movie
import com.example.movieapplication.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
    }




    private fun getMoviesFromCache(): List<Movie>? {

    }


    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try{
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (exception: Exception){

        }

        return movieList
    }
}