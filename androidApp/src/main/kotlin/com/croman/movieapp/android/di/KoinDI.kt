package com.croman.movieapp.android.di

import com.croman.MovieDatabase
import com.croman.movieapp.android.MainActivity
import com.croman.movieapp.android.view_model.MovieViewModel
import com.croman.movieappkmm.business.MovieService
import com.croman.movieappkmm.business.MovieServiceImpl
import com.croman.movieappkmm.dao.LocalMovieDao
import com.croman.movieappkmm.dao.RemoteMovieDao
import com.croman.movieappkmm.dao.sql_delight.DatabaseDriverFactory
import com.croman.movieappkmm.dao.sql_delight.MovieRatingDao
import com.croman.movieappkmm.dao.tmdb.TmdbMovieDao
import com.croman.movieappkmm.http.createHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


fun initKoin(mainActivity: MainActivity) = startKoin {
    androidContext(mainActivity)
    modules(
        module { single { createHttpClient() } },
        module { single { DatabaseDriverFactory(get()).createDriver() } }, // Create a sql driver
        module { single { MovieDatabase(get()) } },
        module { single<LocalMovieDao> { MovieRatingDao(get()) } },
        module { single<RemoteMovieDao> { TmdbMovieDao(get()) } },
        module { single<MovieService> { MovieServiceImpl(get(), get()) } },
        module { viewModel { MovieViewModel(get()) } }
    )
}