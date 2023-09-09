package com.croman.movieappkmm.business

import com.croman.movieappkmm.dao.LocalMovieDao
import com.croman.movieappkmm.dao.RemoteMovieDao
import com.croman.movieappkmm.dao.sql_delight.MovieRatingDao
import com.croman.movieappkmm.model.Movie
import com.croman.movieappkmm.model.db.MovieRating
import com.croman.movieappkmm.model.tmdb.TmdbMovie

class MovieServiceImpl(
    private val remoteMovieDao: RemoteMovieDao,
    private val localMovieDao: LocalMovieDao
) : MovieService {

    override suspend fun retrieveMovies() : List<Movie> {
        val tmdbMovies = remoteMovieDao.retrieveAllMovies()
        val movieRatings = localMovieDao.retrieveAllMovies()
        return tmdbMovies.map {
            toMovie(it, movieRatings.find { movieRating -> movieRating.id == it.id })
        }
    }

    private fun toMovie(tmdbMovie: TmdbMovie, movieRating: MovieRating?) =
        Movie(
            id = tmdbMovie.id,
            overview = tmdbMovie.overview,
            poster = tmdbMovie.poster,
            releaseDate = tmdbMovie.releaseDate,
            title = tmdbMovie.title,
            rating = movieRating?.rating ?: 0
        )


}