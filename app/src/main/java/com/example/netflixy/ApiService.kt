package com.example.netflixy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun searchMovies(@Query("apikey") apiKey: String = "399b5e21", @Query("s") name: String, @Query("type") type: String = "movie"): Call<MovieList>

    @GET(".")
    fun getMovieDetail(@Query("apikey") apiKey: String = "399b5e21", @Query("i") imdbID: String, @Query("type") type: String = "movie", @Query("ploat") ploat: String = "full") : Call<MovieDetail>
}