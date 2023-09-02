package com.croman.movieappkmm.data.sources.tmdb

import com.croman.movieappkmm.data.model.Movie
import com.croman.movieappkmm.data.model.Result
import com.croman.movieappkmm.data.sources.MovieService
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url


private const val BASE_URL = "https://api.themoviedb.org/3"
private const val GET_MOVIES_EP = "$BASE_URL/movie/popular"
private const val KEY = "645bf61561bf1fe3b3361c35e489b81f"

class TmdbService(private val httpClient: HttpClient) : MovieService {

    override suspend fun getMovies() : List<Movie> {
        val result: Result =  httpClient.get {
            url(GET_MOVIES_EP)
            parameter("api_key", KEY)
        }.body()

        return result.movies
    }
}