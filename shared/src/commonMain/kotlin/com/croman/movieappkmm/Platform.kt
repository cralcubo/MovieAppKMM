package com.croman.movieappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

