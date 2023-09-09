package com.croman.movieappkmm.dao

import com.croman.movieappkmm.model.tmdb.TmdbMovie

interface RemoteMovieDao {
    suspend fun retrieveAllMovies(): List<TmdbMovie>
}