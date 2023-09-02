package com.croman.movieapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.croman.movieapp.android.di.initKoin
import com.croman.movieapp.android.view.MoviesListView
import com.croman.movieapp.android.view_model.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    MainScreen(viewModel = MovieViewModel(getMovieRetriever()))
                    MainScreen(viewModel = this.viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MovieViewModel) {
    val state by viewModel.movieState.collectAsState()
    MoviesListView(movies = state)
}