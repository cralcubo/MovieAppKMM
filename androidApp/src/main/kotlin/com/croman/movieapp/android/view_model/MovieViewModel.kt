package com.croman.movieapp.android.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.croman.movieappkmm.business.MovieService
import com.croman.movieappkmm.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRetriever: MovieService) : ViewModel() {
    private val mutableState = MutableStateFlow(emptyList<Movie>())

    val tmdbMovieState: StateFlow<List<Movie>> by ::mutableState

    init {
        viewModelScope.launch {
            mutableState.value = movieRetriever.retrieveMovies()
        }
    }
}