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
import com.croman.movieappkmm.dao.sql_delight.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    private val viewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin(this@MainActivity)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(viewModel = this.viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MovieViewModel) {
    val state by viewModel.tmdbMovieState.collectAsState()
    MoviesListView(movies = state)
}
