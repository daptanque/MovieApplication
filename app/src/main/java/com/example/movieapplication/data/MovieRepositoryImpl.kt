package com.example.movieapplication.data

import com.example.movieapplication.data.datasource.MovieCacheDataSource
import com.example.movieapplication.data.datasource.MovieLocalDataSource
import com.example.movieapplication.data.datasource.MovieRemoteDataSource
import com.example.movieapplication.data.model.Movie
import com.example.movieapplication.data.model.MovieList
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
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }




    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList : List<Movie>

        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){

        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromRoom()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        var movieList: List<Movie> = emptyList()

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

    suspend fun getMoviesFromRoom(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        }catch (exception: Exception){

        }

        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

}