package com.croman.movieappkmm.dao

import com.croman.movieappkmm.model.db.MovieRating

interface LocalMovieDao {
    fun retrieveAllMovies() : List<MovieRating>
}