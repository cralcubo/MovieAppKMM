package com.croman.movieapp.android.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.croman.movieappkmm.model.Movie

@Composable
fun MoviesListView(movies: List<Movie>) {
    LazyColumn {
        items(movies) {
            MovieCard(movie = it)
        }
    }
}

private const val IMDB_POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movie: Movie) {
    Box {
        GlideImage(
            model = "$IMDB_POSTER_BASE_URL/${movie.poster}",
            contentDescription = "Movie Poster",
            modifier = Modifier
                .padding(6.dp)
                .size(width = 140.dp, height = 180.dp)
        )
        Text(text = movie.title)
    }
}