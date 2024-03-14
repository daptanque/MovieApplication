package com.example.movieapplication.data

import com.google.gson.annotations.SerializedName
data class Movie(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("overview")
    val movieOverview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val movieTitle: String
){



}