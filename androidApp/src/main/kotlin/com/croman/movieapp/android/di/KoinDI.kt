package com.croman.movieapp.android.di

import com.croman.movieapp.android.view_model.MovieViewModel
import com.croman.movieappkmm.data.sources.MovieRetriever
import com.croman.movieappkmm.data.sources.MovieService
import com.croman.movieappkmm.data.sources.RemoteMovieRetriever
import com.croman.movieappkmm.data.sources.tmdb.TmdbService
import com.croman.movieappkmm.http.createHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


fun initKoin()  = startKoin {
    modules(
        module { single { createHttpClient() } },
        module { single<MovieService> { TmdbService(get()) } },
        module { single<MovieRetriever> { RemoteMovieRetriever(get()) } },
        module { viewModel { MovieViewModel(get()) } }
    )
}