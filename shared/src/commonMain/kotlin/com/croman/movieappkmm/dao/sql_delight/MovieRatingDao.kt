package com.croman.movieappkmm.dao.sql_delight

import com.croman.MovieDatabase
import com.croman.movieappkmm.dao.LocalMovieDao
import com.croman.movieappkmm.model.db.MovieRating
import com.croman.MovieRating as DBMovieRating

class MovieRatingDao(database: MovieDatabase) : LocalMovieDao {
    private val queries by lazy { database.movieQueries }
    override fun retrieveAllMovies() : List<MovieRating> {
        return queries.retrieveAllMovieRatings()
            .executeAsList()
            .map { it.toMovieRating() }
    }

    private fun DBMovieRating.toMovieRating() =
        MovieRating(
            id = this.id.toInt(),
            rating = this.rating.toInt()
        )
}