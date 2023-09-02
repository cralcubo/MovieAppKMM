package com.croman.movieappkmm.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("results")
    val movies: List<Movie>
)
