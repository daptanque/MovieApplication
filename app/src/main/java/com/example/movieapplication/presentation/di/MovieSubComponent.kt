package com.example.movieapplication.presentation.di

import android.app.Activity
import com.example.movieapplication.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MainActivity)

    @Subcomponent.Factory
    interface  Factory{
        fun create(): MovieSubComponent
    }

}