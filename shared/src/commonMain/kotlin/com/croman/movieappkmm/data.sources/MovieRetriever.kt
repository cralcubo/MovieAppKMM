package com.croman.movieappkmm.data.sources

import com.croman.movieappkmm.data.model.Movie

interface MovieRetriever {
    suspend fun retrieveMovies(): List<Movie>
}