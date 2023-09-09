package com.croman.movieappkmm.model

data class Movie(
    val id: Int,
    val overview: String,
    val poster: String,
    val releaseDate: String,
    val title: String,
    val rating: Int
)