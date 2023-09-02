package com.croman.movieappkmm.data.sources

import com.croman.movieappkmm.data.model.Movie

interface MovieService {

    suspend fun getMovies() : List<Movie>

}