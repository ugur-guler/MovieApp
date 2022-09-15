package com.alcatras.movieapp.Service

import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/now_playing?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getPlayingMovieList(): Call<MovieResponse>
    @GET("/3/movie/top_rated?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getTopRatedMovieList(): Call<MovieResponse>
    @GET("/3/movie/upcoming?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getUpcomingPopularMovieList(): Call<MovieResponse>
    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getPopularMovieList(): Call<MovieResponse>
}