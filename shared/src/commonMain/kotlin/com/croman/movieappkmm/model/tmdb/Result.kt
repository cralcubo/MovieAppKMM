package com.croman.movieappkmm.model.tmdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("results")
    val tmdbMovies: List<TmdbMovie>
)
