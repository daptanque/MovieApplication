package com.example.movieapplication.data.datasourceImpl

import com.example.movieapplication.data.datasource.MovieCacheDataSource
import com.example.movieapplication.data.model.Movie

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }


}