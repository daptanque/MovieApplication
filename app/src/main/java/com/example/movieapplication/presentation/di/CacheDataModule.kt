package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.datasource.MovieCacheDataSource
import com.example.movieapplication.data.datasourceImpl.MovieCacheDataSourceImpl
import com.example.movieapplication.data.datasourceImpl.MovieLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

}