package com.croman.movieappkmm.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val overview: String,
    @SerialName("poster_path")
    val poster: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
)



