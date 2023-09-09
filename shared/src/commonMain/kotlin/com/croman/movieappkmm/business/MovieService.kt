package com.croman.movieappkmm.business

import com.croman.movieappkmm.model.Movie

interface MovieService {
    suspend fun retrieveMovies(): List<Movie>
}