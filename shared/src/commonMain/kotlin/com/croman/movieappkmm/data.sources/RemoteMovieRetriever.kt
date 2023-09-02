package com.croman.movieappkmm.data.sources

import com.croman.movieappkmm.data.model.Movie

class RemoteMovieRetriever(private val movieService: MovieService) : MovieRetriever {

    override suspend fun retrieveMovies() : List<Movie> =
        movieService.getMovies()

}