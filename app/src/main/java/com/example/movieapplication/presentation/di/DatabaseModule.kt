package com.example.movieapplication.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.db.MovieDAO
import com.example.movieapplication.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context,
            TMDBDatabase::class.java,
            "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun providesMovieDAO(tmdbDatabase: TMDBDatabase): MovieDAO{
        return tmdbDatabase.movieDao()
    }

}