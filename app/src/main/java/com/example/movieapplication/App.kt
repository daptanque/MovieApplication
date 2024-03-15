package com.example.movieapplication

import android.app.Application
import com.example.movieapplication.presentation.di.AppComponent
import com.example.movieapplication.presentation.di.AppModule
import com.example.movieapplication.presentation.di.DaggerAppComponent

import com.example.movieapplication.presentation.di.Injector
import com.example.movieapplication.presentation.di.MovieSubComponent
import com.example.movieapplication.presentation.di.NetModule
import com.example.movieapplication.presentation.di.RemoteDataModule

class App : Application(),Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

}