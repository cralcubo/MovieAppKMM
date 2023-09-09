package com.croman.movieappkmm.model.tmdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TmdbMovie(
    val id: Int,
    val overview: String,
    @SerialName("poster_path")
    val poster: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
)



