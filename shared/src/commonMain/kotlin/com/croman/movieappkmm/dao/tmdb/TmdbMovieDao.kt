package com.croman.movieappkmm.dao.tmdb

import com.croman.movieappkmm.dao.RemoteMovieDao
import com.croman.movieappkmm.model.tmdb.TmdbMovie
import com.croman.movieappkmm.model.tmdb.Result
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

private const val BASE_URL = "https://api.themoviedb.org/3"
private const val GET_MOVIES_EP = "$BASE_URL/movie/popular"
private const val KEY = "645bf61561bf1fe3b3361c35e489b81f"

class TmdbMovieDao(private val httpClient: HttpClient) : RemoteMovieDao {
    override suspend fun retrieveAllMovies(): List<TmdbMovie> {
        val result: Result =  httpClient.get {
            url(GET_MOVIES_EP)
            parameter("api_key", KEY)
        }.body()

        return result.tmdbMovies
    }
}