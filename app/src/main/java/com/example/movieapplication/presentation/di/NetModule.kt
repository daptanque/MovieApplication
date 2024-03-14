package com.example.movieapplication.presentation.di

import com.example.movieapplication.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetModule(
    private val baseUrl: String
) {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }

}