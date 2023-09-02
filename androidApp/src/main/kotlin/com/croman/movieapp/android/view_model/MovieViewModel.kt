package com.croman.movieapp.android.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.croman.movieappkmm.data.model.Movie
import com.croman.movieappkmm.data.sources.MovieRetriever
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRetriever: MovieRetriever) : ViewModel() {
    private val mutableState = MutableStateFlow(emptyList<Movie>())

    val movieState: StateFlow<List<Movie>> by ::mutableState

    init {
        viewModelScope.launch {
            mutableState.value = movieRetriever.retrieveMovies()
        }
    }
}